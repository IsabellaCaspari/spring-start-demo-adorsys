package com.adorsys.demo.service;

import java.util.List;

import com.adorsys.demo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.demo.entity.Employee;
import com.adorsys.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Employee> getEmployee() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomException("Employee nicht gefunden " + id));
    }

    @Override
    public Employee createEmployee(Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Employee newEmployee, Long id) {
        return repository.findById(id).map((oldEmployee) -> {
            oldEmployee.setName(newEmployee.getName());
            oldEmployee.setCity(newEmployee.getCity());
            oldEmployee.setHobby(newEmployee.getHobby());
            return repository.save(oldEmployee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

}
