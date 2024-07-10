package com.Worker.Attendance.System.attendance.services;

import com.Worker.Attendance.System.attendance.model.Employee;
import com.Worker.Attendance.System.attendance.model.Manager;
import com.Worker.Attendance.System.attendance.repo.EmployeeRepository;
import com.Worker.Attendance.System.attendance.repo.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ManagerServices {
    private final ManagerRepository managerRepository;

    @Autowired

    public ManagerServices(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }
    public List<Manager> getALLManager(){
        return managerRepository.findAll();
    }
    public Optional<Manager> getManagerById(Integer id){
        return managerRepository.findById(id);
    }
    public Manager addManager(Manager manager){
        return managerRepository.save(manager);
    }
    public void deleteManager(Integer id){
        managerRepository.deleteById(id);
    }
    public Manager update(int id, Manager managerDetails){
        Manager manager = managerRepository.findById(id).orElse(null);
        if (manager!= null){
            manager.setName(managerDetails.getName());
            manager.setName(managerDetails.getName());
            return managerRepository.save(manager);

        }
        return null;
    }
}
