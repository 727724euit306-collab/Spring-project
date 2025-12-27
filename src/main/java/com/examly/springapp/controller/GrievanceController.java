package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Grievance;
import com.examly.springapp.service.GrievanceService;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    @Autowired
    private GrievanceService grievanceService;

    @PostMapping
    public ResponseEntity<Grievance> addGrievance(@RequestBody(required = false) Grievance grievance) {
        if (grievance == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(grievanceService.addGrievance(grievance), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Grievance>> getAllGrievances() {
        List<Grievance> list = grievanceService.getAllGrievances();
        return list.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGrievanceById(@PathVariable Long id) {
        Grievance grievance = grievanceService.getGrievanceById(id);
        if (grievance == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Grievance not found");
        }
        return ResponseEntity.ok(grievance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grievance> updateGrievance(
            @PathVariable Long id,
            @RequestBody Grievance grievance) {

        Grievance updated = grievanceService.updateGrievance(id, grievance);
        return updated == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrievance(@PathVariable Long id) {
        grievanceService.deleteGrievance(id);
        return ResponseEntity.noContent().build();
    }
}
