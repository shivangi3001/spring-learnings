package com.springrest.app.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import com.springrest.app.entity.PinCode;
import com.springrest.app.reader.ExcelItemReader;
import com.springrest.app.writer.PinCodeWriter;

@Configuration
public class MyBatchJobConfiguration {
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	private PlatformTransactionManager txMngr;

	@Bean
	public ItemReader itemReader() throws Exception {
		
		return new ExcelItemReader("pincode.xlsx");
	}

	@Bean
	public ItemWriter itemWriter() throws Exception {
		return new PinCodeWriter();
	}
	
	@Bean
	public Step step1() throws Exception {
		return new StepBuilder("step1", jobRepo)
				.<PinCode, PinCode>chunk(5, txMngr)
				.reader(itemReader())
				.writer(itemWriter())
				.build();
	}
	
//	@Bean
//	public JobRegistry jobRegistry() {
//	    return new MapJobRegistry();
//	}
//	
//	@Bean
//	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
//	    JobRegistryBeanPostProcessor processor = new JobRegistryBeanPostProcessor();
//	    processor.setJobRegistry(jobRegistry);
//	    return processor;
//	}
	
	
	@Bean
	public Job pincodeBatchJob() throws Exception {
		return new JobBuilder("job1", jobRepo)
				.incrementer(new RunIdIncrementer())
				.start(step1())
				.build();
	}
	
	
	
	
	
		
		
		
		
		
		
}
