package com.springorm.dao;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;


public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public int insert(Student student){
		Integer i=(Integer) this.hibernateTemplate.save(student);
		return i;
		
	}
	
	public Student getStudent(int id) {
		Student st=this.hibernateTemplate.get(Student.class,id);
		return st;
	}
	public List<Student> getAllStudents(){
		List<Student> st=this.hibernateTemplate.loadAll(Student.class);
		return st;
	}
	
	@Transactional
	public void deleteStudent(int id) {
		Student st= this.hibernateTemplate.get(Student.class,id);
		this.hibernateTemplate.delete(st);
	}
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
}
