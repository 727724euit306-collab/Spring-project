package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.repository.GrievanceCategoryRepository;

@Service
public class GrievanceCategoryServiceImpl implements GrievanceCategoryService {

    @Autowired
    private GrievanceCategoryRepository grievanceCategoryRepository;

    @Override
    public GrievanceCategory addCategory(GrievanceCategory category) {
        return grievanceCategoryRepository.save(category);
    }

    @Override
    public List<GrievanceCategory> getAllCategories() {
        return grievanceCategoryRepository.findAll();
    }

    @Override
    public GrievanceCategory getCategoryById(Long id) {
        return grievanceCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GrievanceCategory not found"));
    }

    @Override
    public GrievanceCategory updateCategory(Long id, GrievanceCategory category) {
        GrievanceCategory existing = grievanceCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GrievanceCategory not found"));

        existing.setCategoryName(category.getCategoryName());
        existing.setDescription(category.getDescription());
        existing.setDepartment(category.getDepartment());

        return grievanceCategoryRepository.save(existing);
    }

    @Override
    public List<GrievanceCategory> searchByCategoryName(String keyword) {
        return grievanceCategoryRepository
                .findByCategoryNameContainingIgnoreCase(keyword);
    }
}
