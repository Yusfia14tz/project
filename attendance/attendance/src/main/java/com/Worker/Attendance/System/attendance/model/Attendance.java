package com.Worker.Attendance.System.attendance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

@Data
@Entity
@AllArgsConstructor
@Builder

public class Attendance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int Employee_id;
    private Date Attendance_date;
    private Time clock_in;
    private Time clock_out;
}
