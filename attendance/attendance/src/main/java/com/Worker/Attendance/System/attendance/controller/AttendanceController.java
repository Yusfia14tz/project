package com.Worker.Attendance.System.attendance.controller;

import com.Worker.Attendance.System.attendance.model.Attendance;
import com.Worker.Attendance.System.attendance.services.AttendanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceServices attendanceServices;

    @Autowired
    public AttendanceController(AttendanceServices attendanceServices) {
        this.attendanceServices = attendanceServices;
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceServices.getALLAttendance();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Integer id) {
        Optional<Attendance> attendance = attendanceServices.getAttendanceById(id);
        return attendance.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceServices.addAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Integer id) {
        attendanceServices.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Integer id, @RequestBody Attendance attendanceDetails) {
        Attendance updatedAttendance = attendanceServices.update(id, attendanceDetails);
        if (updatedAttendance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAttendance);
    }
}
