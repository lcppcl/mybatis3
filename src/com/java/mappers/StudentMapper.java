package com.java.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.java.model.Student;
//�ӿ�
public interface StudentMapper {
	
	//����ѧ��    clob��blob����
	public int insertStudent(Student student);
	//ȡ��ѧ��    clob��blob����
	public Student getStudentById(Integer id);
	//���������������в���
	public List<Student> searchStudent(String name, int i); 
	//�߼���ҳ
	public List<Student> findStudents(RowBounds bounds);
	//�����ķ�ҳ
	public List<Student> findStudents2(Map<String, Object> map);
}
