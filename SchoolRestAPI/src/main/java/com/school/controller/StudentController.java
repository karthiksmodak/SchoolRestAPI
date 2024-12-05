package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.school.entity.*;
import com.school.repository.StudentRepository;
@RestController
public class StudentController {
	//get all the students
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students=	studentRepository.findAll();
		return students;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id){
		Student student=studentRepository.findById(id).get();
		return student;
	}
	
	@PostMapping("/students/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addStudent(@RequestBody Student student) {
		studentRepository.save(student);
	}

	
	@PutMapping("/students/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student=studentRepository.findById(id).get();
		student.setName("poonam");
		student.setPercentage(67);
		studentRepository.save(student);
		return student;
	}
	
	@DeleteMapping("/students/delete/{id}")	
	public void deleteStudent(@PathVariable int id) {
		Student student=studentRepository.findById(id).get();
		studentRepository.delete(student);	
	}
}