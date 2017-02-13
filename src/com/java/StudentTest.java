package com.java;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java.mappers.StudentMapper;
import com.java.model.Student;
import com.java.util.SqlSessionFactoryUtil;


//测试数据库连接
public class StudentTest {
	
	private static Logger logger = Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession = null;//打开数据库连接
	private StudentMapper studentMapper = null; //映射器
	@Before   //测试方法执行之前调用
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
	}

	@After    //测试方法执行之后调用
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	/*@Test      //插入图片和大文本
	public void testInsertStudent(){
		logger.info("添加学生");
		Student student = new Student();
		student.setName("战士2");
		student.setAge(21);
		student.setRemark("很长的文本~~~~~~~~~~~~");
		byte []pic = null;
		try{
			File file = new File("C://Users//lcp//Pictures//Saved Pictures//aa.jpg");
			InputStream inputStream = new FileInputStream(file);
			pic = new byte[inputStream.available()];
			inputStream.read(pic);
			inputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		student.setPic(pic);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}*/
	
	
	/*@Test      //获取图片和大文本
	public void tesGetStudent(){
		logger.info("添加学生");
		Student student = studentMapper.getStudentById(6);
		System.out.println(student);
		byte [] pic = student.getPic();
		try {
			File file = new File("D:gg.jpg");
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(pic);
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*@Test      //获取图片和大文本
	public void tesGetStudent(){
		logger.info("添加学生");
		List<Student> studentList = studentMapper.searchStudent("%张%",12);
		for(Student student:studentList){
			System.out.println(student);
		}
	}*/
	
	/*@Test      //逻辑分页      是吧所有的数据重从数据库中取出来放在内存里，每次再从内存中取出三个
	public void tesfindStudent(){
		logger.info("查询学生");
		int offset=0;//从第0个开始
		int limit=3;//每次取三个
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Student> studentList = studentMapper.findStudents(rowBounds);
		for(Student student:studentList){
			System.out.println(student);
		}
	}*/
	
	
	@Test      //真正的物理分页
	public void tesfindStudent(){
		logger.info("查询学生");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 0);
		map.put("size", 3);
		List<Student> studentList = studentMapper.findStudents2(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
}
