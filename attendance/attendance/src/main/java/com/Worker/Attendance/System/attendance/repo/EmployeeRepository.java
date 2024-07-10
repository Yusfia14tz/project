package com.Worker.Attendance.System.attendance.repo;

import com.Worker.Attendance.System.attendance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
