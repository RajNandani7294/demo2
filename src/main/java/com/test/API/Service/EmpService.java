package com.test.API.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.API.EmpRepository.EmplRepository;
import com.test.API.Entity.Employee;

@Component
public class EmpService {
	
	//private static List<Employee> list=new ArrayList<>();
	
	/*static {
	     list.add(new Employee(34,"Rahul","Haryana"));
		 list.add(new Employee(35,"Ram","Delhi"));
		 list.add(new Employee(36,"Ritik","Ambala"));
	}*/
	@Autowired
	private EmplRepository emplRepository;
	
	public List<Employee> getAllDetail(){
		List<Employee>list=(List<Employee>)this.emplRepository.findAll();
		 return list;
	}
	public Employee getById(int id) {
		Employee emp=null;
		try {
		 //emp=list.stream().filter(e->e.getId()==id).findFirst().get();
			Employee emps=this.emplRepository.findById(id);
		}                
		catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public Employee getadd(Employee emp) {
		//list.add(emp);
		Employee emps=this.emplRepository.save(emp);
		return emps;
	}
	
	public void getdelete(int id) {
		//list=list.stream().filter(emp->emp.getId()!=id).collect(Collectors.toList());
		emplRepository.deleteById(id);
	}

}
