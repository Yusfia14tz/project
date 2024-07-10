package com.Worker.Attendance.System.attendance.services;

import com.Worker.Attendance.System.attendance.model.Employee;
import com.Worker.Attendance.System.attendance.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServices {
    private final EmployeeRepository employeeRepository;

    @Autowired

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getALLEmployee(){
        return employeeRepository.findAll();
    }
    public Optional <Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }
    public Employee update(int id, Employee employeeDetails){
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null){
            employee.setName(employeeDetails.getName());
            employee.setRole(employeeDetails.getRole());
            employee.setPassword(employee.getPassword());
            return employeeRepository.save(employee);

        }
        return null;
    }
}
