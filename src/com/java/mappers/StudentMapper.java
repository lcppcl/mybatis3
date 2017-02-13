package com.java.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.java.model.Student;
//接口
public interface StudentMapper {
	
	//插入学生    clob和blob数据
	public int insertStudent(Student student);
	//取出学生    clob和blob数据
	public Student getStudentById(Integer id);
	//输入两个参数进行查找
	public List<Student> searchStudent(String name, int i); 
	//逻辑分页
	public List<Student> findStudents(RowBounds bounds);
	//真正的分页
	public List<Student> findStudents2(Map<String, Object> map);
}
