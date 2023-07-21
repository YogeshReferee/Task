package com.tech.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
	@Autowired
	EmployeeService empSer;

	@PostMapping(value = "/insert")

	public String addEmployee(@RequestBody Employee e) {
		return empSer.addEmployee(e);
	}

	@PostMapping(value = "/insertAll")
	public String addAllEmployee(@RequestBody List<Employee> emps) {
		return empSer.addAllEmployee(emps);
	}

	@GetMapping(value = "/getId/{id}")
	public Employee findEmpId(@PathVariable int id) {
		return empSer.findEmpId(id);
	}

	@GetMapping(value = "/getAllId")
	public List<Employee> findAllEmpId() {
		return empSer.findAllEmpId();
	}

	@GetMapping(value = "/DeleteId/{id}")
	public String DeleteEmpId(@PathVariable int id) {
		return empSer.DeleteEmpId(id);
	}

	@PostMapping(value = "/update/{e}")
	public String updateEmployee(@RequestBody Employee e) {
		return empSer.updateEmp(e);
	}

	@PutMapping(value = "/put/{id}")
	public String putAllValue(@RequestBody Employee e) {
		return empSer.putAllValue(e);
	}
	@PatchMapping(value="/patch/{id}")
	public Employee updateThis(@PathVariable int id, @RequestBody Employee e) {
		return empSer.updateThis(id,e);
	}
	

	//
	//
	@GetMapping(value = "/getByName/{name}")

	public List<Employee> getEmpByName(@PathVariable String name) throws NameNotException {

		return empSer.getEmpByName(name);
	}

	@GetMapping(value = "/getByAge/{age}")
	public List<Employee> getEmpByAge(@PathVariable int age) throws AgeNotException {
		return empSer.getEmpByAge(age);
	}

	@GetMapping(value = "/getByGender/{gender}")
	public List<Employee> getEmpByGender(@PathVariable String gender) throws GenderNotException {
		return empSer.getEmpByGender(gender);
	}

	@GetMapping(value = "/getBySalary/{salary}")
	public List<Employee> getEmpBySalary(@PathVariable int salary) throws SalaryNotException {
		return empSer.getEmpBySalary(salary);
	}

	@GetMapping(value = "/getByMaxSalary")
	public Employee getByMaxSalary() {
		return empSer.getByMaxSalary();
	}

	@GetMapping(value = "/getByMinSalary")
	public String getByMinSalary() {
		return empSer.getByMinSalary();
	}

	@GetMapping(value = "getByMaxAge")
	public int getByMaxAge() {
		return empSer.getByMaxAge();
	}

	@GetMapping(value = "getSecondMax")
	public Employee getBySecondMax() {
		return empSer.getBySecondMax();
	}

	//
	@GetMapping(value = "getSalary/{salary}")
	public List<Employee> getSalary(@PathVariable int salary) {
		return empSer.getSalary(salary);
	}

}
