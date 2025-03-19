package com.student.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.controller.StudentMainAppController;
import com.student.vo.StudentVo;

public class NestedIOCContainerTest {
	
	public static void main(String[] args) {
		ApplicationContext parentCtx, childCtx=null;
		
		parentCtx = new ClassPathXmlApplicationContext("parentApplicationContext.xml");
		
		//create the child ioc container
		
		childCtx = new ClassPathXmlApplicationContext(
				new String[] {"childApplicationContext.xml"}, parentCtx
				);
		
		StudentMainAppController controller = childCtx.getBean("controller", StudentMainAppController.class);
		
		try {
			List<StudentVo> voList = controller.processFetchAllStudentsRecordRequest();
		    System.out.println(voList);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			((AbstractApplicationContext)childCtx).close();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
