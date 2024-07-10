package com.Worker.Attendance.System.attendance.controller;

import org.springframework.web.bind.annotation.RestController;
import com.Worker.Attendance.System.attendance.model.Manager;
import com.Worker.Attendance.System.attendance.services.ManagerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/managers")

public class ManagerController {


        private final ManagerServices managerServices;

        @Autowired
        public ManagerController(ManagerServices managerServices) {
            this.managerServices = managerServices;
        }

        @GetMapping
        public List<Manager> getAllManagers() {
            return managerServices.getALLManager();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Manager> getManagerById(@PathVariable Integer id) {
            Optional<Manager> manager = managerServices.getManagerById(id);
            return manager.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping("/add")
        public Manager createManager(@RequestBody Manager manager) {
            return managerServices.addManager(manager);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteManager(@PathVariable Integer id) {
            managerServices.deleteManager(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Manager> updateManager(@PathVariable Integer id, @RequestBody Manager managerDetails) {
            Manager updatedManager = managerServices.update(id, managerDetails);
            if (updatedManager == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedManager);
        }

}
