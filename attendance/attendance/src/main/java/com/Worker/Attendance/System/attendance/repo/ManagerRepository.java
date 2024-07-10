package com.Worker.Attendance.System.attendance.repo;

import com.Worker.Attendance.System.attendance.model.Employee;
import com.Worker.Attendance.System.attendance.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
