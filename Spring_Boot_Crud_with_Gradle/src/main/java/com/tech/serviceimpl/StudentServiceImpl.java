package com.tech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.Student;
import com.tech.repository.StudentRepository;
import com.tech.servicei.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI{

	@Autowired
	StudentRepository studentRepo;
	
	@Override
	public String addStudent(Student s) {
		
		studentRepo.save(s);
		
		return "Student Id: "+s.getsId()+" is saved successfully";
	}

	@Override
	public Optional<Student> getStudent(String sid) {
		Optional<Student> stu = studentRepo.findById(sid);
		
		return stu;
	}

	@Override
	public String deleteStudent(String sid) {
		
		Optional<Student> optionalStudent = studentRepo.findById(sid);
		if(optionalStudent.isPresent()) {
			
			studentRepo.deleteById(sid);
			return "Student Id: "+sid+" record deleted successfully";
		}
		
		return null;
		
		
	}

	@Override
	public String updateStudent(Student s) {
		
		Optional<Student> optionalStudent = studentRepo.findById(s.getsId());
		if(optionalStudent.isPresent()) {
			
			Student student = studentRepo.save(s);
			
			return "Student Id: "+student.getsId()+" is updated Successfully";
		}
		return null;
	}

	@Override
	public String addStudents(List<Student> s) {
		
		studentRepo.saveAll(s);
		
		return "Data save successfully";
	}

	@Override
	public List<Student> getAllStudent() {
		Iterable<Student> studentList = studentRepo.findAll();
		
		return (List<Student>) studentList;
	}

}
