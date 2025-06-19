package com.test.API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.API.Entity.Employee;
import com.test.API.Service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empservice ;
	
	@GetMapping("/emp")
	public ResponseEntity <List<Employee>>getdetail(){
		 List<Employee>list= this.empservice.getAllDetail();
		 if(list.size()<=0) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/emp{id}")
	public ResponseEntity <Employee> getid(@PathVariable("id") int id) {
		Employee emp= this.empservice.getById(id);
		if(emp==null) {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		}
		 return ResponseEntity.of(Optional.of(emp));
	}
	@PostMapping("/emp")
	public ResponseEntity <Employee> getAdd(@RequestBody Employee emp) {
		try {
			Employee emps= this.empservice.getadd(emp);
			 return ResponseEntity.of(Optional.of(emp));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/emp{id}")
	public ResponseEntity <?> delete(@PathVariable("id") int id)
	{
		try {
	   this.empservice.getdelete(id);
	   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}