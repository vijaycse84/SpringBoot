package com.nit.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Student;
import com.nit.repository.StudentRepository;



@RestController
public class StudentRestController {
	
	@Autowired
	private StudentRepository studRepo;
	@PostMapping(value = "/student",
					consumes = 
					{ 
							"application/xml",
							"application/json"
					}
				)
	public ResponseEntity<String> addStudent(@RequestBody Student stud){
		String msg=null;
		Student save= studRepo.save(stud);
		if(save.getStudentId()!=null) {
			msg="Message saved";
		}
		else {
			msg="failed to save";
		}
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
@GetMapping(value = "/student/{studentId}",produces = {"application/xml","application/json"})

public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId){
	
	Optional<Student> findById=studRepo.findById(studentId);
	System.out.println("************************88");

	if(findById.isPresent()) {
		Student student=findById.get();
		System.out.println("************************99");
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	
}
@GetMapping(value = "/student",produces = {"application/xml","application/json"})
public ResponseEntity<List<Student>> getStudentByAge(@RequestParam("age") Integer age){
	
	List<Student> students=studRepo.findByStudentAgeGreaterThanEqual(age);
	System.out.println("*******************88");
	return new ResponseEntity<>(students,HttpStatus.OK);
	
}
}
