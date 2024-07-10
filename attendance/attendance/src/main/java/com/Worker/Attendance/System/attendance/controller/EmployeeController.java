package com.Worker.Attendance.System.attendance.controller;

import com.Worker.Attendance.System.attendance.model.Employee;
import com.Worker.Attendance.System.attendance.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeServices employeeServices;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeServices.getALLEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeServices.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeServices.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeServices.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeServices.update(id, employeeDetails);
        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmployee);
    }

}
