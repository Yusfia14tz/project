package com.Worker.Attendance.System.attendance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Builder

public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int Employee_id;

}
