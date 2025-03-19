package com.app.dao;

import com.app.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    private static final String GET_ALL_STUDENTS = "SELECT id, name, course, projects FROM student_mvc_table";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<StudentEntity> getAllStudents() {
       List<StudentEntity> studentEntityList = jdbcTemplate.query(GET_ALL_STUDENTS, new StudentExtractor());
       return studentEntityList;
    }




    //nested inner class

    private static class StudentExtractor implements ResultSetExtractor<List<StudentEntity>>{

        @Override
        public List<StudentEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

            List<StudentEntity> entityList = new ArrayList<>();

            while(rs.next()){
                StudentEntity entity = new StudentEntity();
                entity.setId(rs.getInt(1));
                entity.setName(rs.getString(2));
                entity.setCourse(rs.getString(3));
                entity.setProjDone(rs.getInt(4));
                entityList.add(entity);
            }
            return  entityList;
        }
    }


}
