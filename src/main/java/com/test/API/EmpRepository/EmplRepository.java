package com.test.API.EmpRepository;

import org.springframework.data.repository.CrudRepository;

import com.test.API.Entity.Employee;

public interface EmplRepository extends CrudRepository<Employee, Integer> {
   public Employee findById(int id);
}
