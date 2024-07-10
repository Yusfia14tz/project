package com.Worker.Attendance.System.attendance.repo;

import com.Worker.Attendance.System.attendance.model.Employee;
import com.Worker.Attendance.System.attendance.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
