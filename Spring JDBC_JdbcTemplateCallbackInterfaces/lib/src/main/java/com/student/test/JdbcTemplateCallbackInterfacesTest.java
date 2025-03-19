package com.student.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.controller.StudentMainController;
import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;

public class JdbcTemplateCallbackInterfacesTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		StudentMainController controller = context.getBean("controller", StudentMainController.class);
	    
		try {
			StudentDto dto = null;
			dto = controller.processGetStudentDetailsRequest(1004);
			System.out.println(dto);
			
			System.out.println("-----MULTIPLE RECORDS:: RowCallbackHandler------");
			List<StudentDto> studentList = controller.fetchStudentsList("java", "spring", "javascript");
			System.out.println(studentList);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close the ioc container
			((AbstractApplicationContext)context).close();
		}
	
	}

}
