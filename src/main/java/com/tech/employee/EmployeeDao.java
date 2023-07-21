package com.tech.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully saved ";
	}

	public String addAllEmployee(List<Employee> emps) {
		empRepo.saveAll(emps);
		return "Successfully saved ";
	}

	public Employee findEmpId(int id) {
		return empRepo.findById(id).get();
	}

	public List<Employee> findAllEmpId() {
		return empRepo.findAll();
	}

	public String DeleteEmpId(int id) {
		empRepo.deleteById(id);
		return "Deleted Successfully";
	}

	public String updateEmp(Employee e) {
		empRepo.save(e);
		return "Successfully saved ";
	}

	public String putAllValue(Employee e) {
		empRepo.save(e);
		return "Succesfully update";
	}

	public Employee updateThis(int id, Employee e) {
		Employee x = empRepo.findById(id).get();
		x.setSalary(e.getSalary());
		return empRepo.save(x);
	}

	//
	public List<Employee> getSalary(int salary) {
		return empRepo.getSalary(salary);
	}

	public List<Employee> quaryName(String name) {
		return empRepo.quaryName(name);
	}
}
