package com.Worker.Attendance.System.attendance.services;

import com.Worker.Attendance.System.attendance.model.Employee;
import com.Worker.Attendance.System.attendance.model.Report;
import com.Worker.Attendance.System.attendance.repo.EmployeeRepository;
import com.Worker.Attendance.System.attendance.repo.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReportServices {
    private final ReportRepository reportRepository;

    @Autowired

    public ReportServices(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    public List<Report> getALLReport(){
        return reportRepository.findAll();
    }
    public Optional<Report> getReportById(Integer id){
        return reportRepository.findById(id);
    }
    public Report addReport(Report report){
        return reportRepository.save(report);
    }
    public void deleteReport(Integer id){
        reportRepository.deleteById(id);
    }
    public Report update(int id, Report reportDetails){
        Report report = reportRepository.findById(id).orElse(null);
        if (report != null){
            report.setEmployee_id(reportDetails.getEmployee_id());
            return reportRepository.save(report);

        }
        return null;
    }
}
