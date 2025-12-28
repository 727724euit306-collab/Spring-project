package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Grievance;
import com.examly.springapp.repository.GrievanceRepository;

@Service
public class GrievanceServiceImpl implements GrievanceService {

    @Autowired
    private GrievanceRepository grievanceRepository;

    @Override
    public Grievance addGrievance(Grievance grievance) {
        return grievanceRepository.save(grievance);
    }

    @Override
    public List<Grievance> getAllGrievances() {
        return grievanceRepository.findAll();
    }

    @Override
    public Grievance getGrievanceById(Long id) {
        return grievanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grievance not found"));
    }

    @Override
    public Grievance updateGrievance(Long id, Grievance grievance) {
        Grievance existing = grievanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grievance not found"));

        existing.setTitle(grievance.getTitle());
        existing.setDescription(grievance.getDescription());
        existing.setPriority(grievance.getPriority());
        existing.setComplainant(grievance.getComplainant());
        existing.setGrievanceCategory(grievance.getGrievanceCategory());

        return grievanceRepository.save(existing);
    }

    @Override
    public void deleteGrievance(Long id) {
        Grievance grievance = grievanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grievance not found"));

        grievanceRepository.delete(grievance);
    }
}
