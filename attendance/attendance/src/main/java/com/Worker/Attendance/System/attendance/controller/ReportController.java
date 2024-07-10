package com.Worker.Attendance.System.attendance.controller;

import com.Worker.Attendance.System.attendance.model.Report;
import com.Worker.Attendance.System.attendance.services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportServices reportServices;

    @Autowired
    public ReportController(ReportServices reportServices) {
        this.reportServices = reportServices;
    }

    @GetMapping
    public List<Report> getAllReports() {
        return reportServices.getALLReport();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Integer id) {
        Optional<Report> report = reportServices.getReportById(id);
        return report.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Report createReport(@RequestBody Report report) {
        return reportServices.addReport(report);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Integer id) {
        reportServices.deleteReport(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Integer id, @RequestBody Report reportDetails) {
        Report updatedReport = reportServices.update(id, reportDetails);
        if (updatedReport == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedReport);
    }
}
