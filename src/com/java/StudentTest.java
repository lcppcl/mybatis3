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


//�������ݿ�����
public class StudentTest {
	
	private static Logger logger = Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession = null;//�����ݿ�����
	private StudentMapper studentMapper = null; //ӳ����
	@Before   //���Է���ִ��֮ǰ����
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
	}

	@After    //���Է���ִ��֮�����
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	/*@Test      //����ͼƬ�ʹ��ı�
	public void testInsertStudent(){
		logger.info("���ѧ��");
		Student student = new Student();
		student.setName("սʿ2");
		student.setAge(21);
		student.setRemark("�ܳ����ı�~~~~~~~~~~~~");
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
	
	
	/*@Test      //��ȡͼƬ�ʹ��ı�
	public void tesGetStudent(){
		logger.info("���ѧ��");
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
	
	/*@Test      //��ȡͼƬ�ʹ��ı�
	public void tesGetStudent(){
		logger.info("���ѧ��");
		List<Student> studentList = studentMapper.searchStudent("%��%",12);
		for(Student student:studentList){
			System.out.println(student);
		}
	}*/
	
	/*@Test      //�߼���ҳ      �ǰ����е������ش����ݿ���ȡ���������ڴ��ÿ���ٴ��ڴ���ȡ������
	public void tesfindStudent(){
		logger.info("��ѯѧ��");
		int offset=0;//�ӵ�0����ʼ
		int limit=3;//ÿ��ȡ����
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Student> studentList = studentMapper.findStudents(rowBounds);
		for(Student student:studentList){
			System.out.println(student);
		}
	}*/
	
	
	@Test      //�����������ҳ
	public void tesfindStudent(){
		logger.info("��ѯѧ��");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 0);
		map.put("size", 3);
		List<Student> studentList = studentMapper.findStudents2(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
}
