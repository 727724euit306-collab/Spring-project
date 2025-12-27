package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Grievance;

public interface GrievanceService {

    Grievance addGrievance(Grievance grievance);

    List<Grievance> getAllGrievances();

    Grievance getGrievanceById(Long id);

    Grievance updateGrievance(Long id, Grievance grievance);

    void deleteGrievance(Long id);
}
