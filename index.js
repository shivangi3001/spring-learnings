// Import required modules
import fs from "fs";
import path from "path";
import moment from "moment";
import simpleGit from "simple-git";
import random from "random";

// Initialize simple-git instance
const git = simpleGit();

// Array of commit messages for random selection
const messages = [
  "Added new feature",
  "Fixed bug in logic",
  "Updated documentation",
  "Refactored code",
  "Initial project setup",
];

// Utility function to randomly sample k elements from an array (not used in this version but kept for compatibility)
function sampleSize(array, k) {
  const shuffled = array.slice().sort(() => 0.5 - Math.random());
  return shuffled.slice(0, k);
}

// Ensure the directory is a Git repository with the main branch
async function ensureGitRepo() {
  const isRepo = await git.checkIsRepo();
  if (!isRepo) {
    console.log("🔹 Git repository not found. Initializing with main branch...");
    await git.init();
    // Set the default branch to main
    await git.raw(["symbolic-ref", "HEAD", "refs/heads/main"]);
    console.log("✅ Git repository initialized with main branch.");
  } else {
    console.log("✅ Git repository already initialized.");
  }
}

// Ensure there is an initial commit in the repository on the main branch
async function ensureInitialCommit() {
  const log = await git.log();
  if (log.total === 0) {
    console.log("📝 No commits found. Creating an initial commit on main branch...");
    fs.writeFileSync("README.md", "# Auto-Generated Repository\n");
    await git.add("README.md");
    await git.commit("Initial commit");
    console.log("✅ Initial commit created on main branch.");
  }
}

// Setup Git repository by ensuring it's initialized, has an initial commit, and a .gitignore
async function setupGit() {
  await ensureGitRepo();
  await ensureInitialCommit();
  // Create .gitignore if it doesn't exist
  if (!fs.existsSync(".gitignore")) {
    console.log("🔧 Creating .gitignore...");
    fs.writeFileSync(".gitignore", "node_modules/\n");
    await git.add(".gitignore");
    await git.commit("Add .gitignore");
    console.log("✅ .gitignore added.");
  }
}

// Main function to automate commits across subfolders
async function makeCommits() {
  // **Step 1: List subfolders, excluding .git, and sort alphabetically**
  const subfolders = fs
    .readdirSync(".")
    .filter((file) => fs.statSync(file).isDirectory() && file !== ".git")
    .sort();

  // Verify exactly 35 subfolders are present
  if (subfolders.length !== 35) {
    console.error("❌ Expected 35 subfolders, found:", subfolders.length);
    return;
  }

  // **Step 2: Define the date range**
  const startDate = moment("2024-05-10");
  const endDate = moment("2025-02-23");
  const diff = endDate.diff(startDate, "seconds"); // Difference in seconds for random timestamp generation

  // **Step 3: Assign commits per folder**
  // Total commits = 239, each of 35 folders gets at least 1 commit (35 commits),
  // remaining 204 commits are distributed randomly
  const commitsPerFolder = Array(35).fill(1); // Start with 1 commit per folder
  for (let i = 0; i < 204; i++) {
    const index = random.int(0, 34); // Randomly select a folder index (0 to 34)
    commitsPerFolder[index]++; // Increment commit count for that folder
  }

  const commits = [];

  // **Step 4: Plan commits for each subfolder**
  for (let i = 0; i < 35; i++) {
    const subfolder = subfolders[i];
    const numCommits = commitsPerFolder[i];

    // Generate random timestamps for this subfolder
    const timestamps = [];
    for (let j = 0; j < numCommits; j++) {
      const randomSeconds = random.int(0, diff);
      const timestamp = startDate.clone().add(randomSeconds, "seconds");
      timestamps.push(timestamp);
    }

    // Sort timestamps to ensure initial commit is earliest for this subfolder
    timestamps.sort((a, b) => a - b);

    // Plan commits: first is initial, rest are modifications
    for (let k = 0; k < timestamps.length; k++) {
      const timestamp = timestamps[k];
      if (k === 0) {
        // Initial commit
        commits.push({
          subfolder,
          timestamp,
          type: "initial",
          message: `Add commit_log.txt in ${subfolder}`,
        });
      } else {
        // Modification commit
        const message = messages[random.int(0, messages.length - 1)];
        commits.push({
          subfolder,
          timestamp,
          type: "modify",
          message,
        });
      }
    }
  }

  // **Step 5: Sort all commits by timestamp**
  commits.sort((a, b) => a.timestamp - b.timestamp);

  // **Step 6: Execute commits sequentially**
  for (const commit of commits) {
    const logFile = path.join(commit.subfolder, "commit_log.txt");

    if (commit.type === "initial") {
      console.log(
        `🟢 Initial commit in ${commit.subfolder} on ${commit.timestamp.format()}`
      );
      // Create the file (overwrite if it exists, assuming fresh run)
      fs.writeFileSync(logFile, "Initial commit\n");
      await git.add(logFile);
      await git.commit(commit.message, { "--date": commit.timestamp.format() });
    } else {
      console.log(
        `🔄 Modified ${commit.subfolder} on ${commit.timestamp.format()}`
      );
      fs.appendFileSync(
        logFile,
        `Commit on ${commit.timestamp.format()}: ${commit.message}\n`
      );
      await git.add(logFile);
      await git.commit(commit.message, { "--date": commit.timestamp.format() });
    }
  }

  // **Step 7: Push all commits to the remote repository**
  await git.push("origin", "main", { "--set-upstream": true });
  console.log("🚀 All commits pushed to remote repository.");
}

// Execute the script: setup Git first, then make commits
setupGit()
  .then(() => {
    console.log("🚀 Git is ready. You can now make commits.");
    return makeCommits();
  })
  .catch((err) => console.error("❌ Error:", err));