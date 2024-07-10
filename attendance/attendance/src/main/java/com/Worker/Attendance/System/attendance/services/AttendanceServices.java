package com.Worker.Attendance.System.attendance.services;

import com.Worker.Attendance.System.attendance.model.Attendance;
import com.Worker.Attendance.System.attendance.model.Employee;
import com.Worker.Attendance.System.attendance.repo.AttendanceRepository;
import com.Worker.Attendance.System.attendance.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AttendanceServices {
    private final AttendanceRepository attendanceRepository;
    @Autowired

    public AttendanceServices(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }
    public List<Attendance> getALLAttendance(){
        return attendanceRepository.findAll();
    }
    public Optional<Attendance> getAttendanceById(Integer id){
        return attendanceRepository.findById(id);
    }
    public Attendance addAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }
    public void deleteAttendance(Integer id){
        attendanceRepository.deleteById(id);
    }
    public Attendance update(int id, Attendance attendanceDetails){
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        if (attendance != null){
            attendance.setEmployee_id(attendanceDetails.getEmployee_id());
            attendance.setAttendance_date(attendanceDetails.getAttendance_date());
            attendance.setClock_in(attendanceDetails.getClock_in());
            attendance.setClock_out(attendanceDetails.getClock_out());
            return attendanceRepository.save(attendance);

        }
        return null;
    }

    }


