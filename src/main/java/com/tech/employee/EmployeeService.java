package com.tech.employee;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e)  {
		
				return empDao.addEmployee(e);
		
	}

	public String addAllEmployee(List<Employee> emps) {
		return empDao.addAllEmployee(emps);
	}

	public Employee findEmpId(int id) {
		return empDao.findEmpId(id);
	}

	public List<Employee> findAllEmpId() {
		return empDao.findAllEmpId();
	}

	public String DeleteEmpId(int id) {
		return empDao.DeleteEmpId(id);
	}

	public String updateEmp(Employee e) {
		return empDao.updateEmp(e);

	}
	//put
	public String putAllValue(Employee e) {
		return empDao.putAllValue(e);
	}
	//patch
	public Employee updateThis( int id, Employee e) {
		return empDao.updateThis(id,e);
	}

	//
	//
	public List<Employee> getEmpByName(String name) throws NameNotException {
		List<Employee> allEmp = empDao.findAllEmpId();
		List<Employee> temp = allEmp.stream().filter(x -> x.getName().equals(name)).toList();
		if (temp.isEmpty()) {
			throw new NameNotException("there is not name");
		} else {
			return temp;
		}

	}

	public List<Employee> getEmpByAge(int age) throws AgeNotException {
		List<Employee> allEmp = empDao.findAllEmpId();
		List<Employee> xx = allEmp.stream().filter(x -> x.getAge() == age).toList();
		if (xx.isEmpty()) {
			throw new AgeNotException("there is no age");
		} else {
			return xx;
		}

	}

	public List<Employee> getEmpByGender(String gender) throws GenderNotException {
		List<Employee> allEmp = empDao.findAllEmpId();
		List<Employee> yy = allEmp.stream().filter(x -> x.getGender().equals(gender)).toList();
		if (yy.isEmpty()) {
			throw new GenderNotException("Given not valid");
		}
		return yy;
	}

	public List<Employee> getEmpBySalary(int salary) throws SalaryNotException {
		List<Employee> allEmp = empDao.findAllEmpId();
		List<Employee> zz = allEmp.stream().filter(x -> x.getSalary() == salary).toList();
		if (zz.isEmpty()) {
			throw new SalaryNotException("Given not valid");
		}
		return zz;
	}

	public Employee getByMaxSalary() {
		List<Employee> allEmp = empDao.findAllEmpId();
		return allEmp.stream().max(Comparator.comparing(Employee::getSalary)).get();
	}

	public String getByMinSalary() {
		List<Employee> allEmp = empDao.findAllEmpId();
		return allEmp.stream().min(Comparator.comparing(Employee::getSalary)).map(x -> x.getName()).get();
	}

	public int getByMaxAge() {
		List<Employee> allEmp = empDao.findAllEmpId();
		return allEmp.stream().max(Comparator.comparing(Employee::getAge)).map(x -> x.getSalary()).get();
	}

	public Employee getBySecondMax() {
		List<Employee> allEmp = empDao.findAllEmpId();
		return allEmp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
	}

	//
	public List<Employee> getSalary(int salary) {
		return empDao.getSalary(salary);

	}
	public List<Employee> quaryName(String name) throws Exception {
		if(name.equals(name)) {
			throw new NameNotException("name not aviable");
		}else 
			return empDao.quaryName(name);
}
}