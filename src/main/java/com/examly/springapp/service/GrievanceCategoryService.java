package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.GrievanceCategory;

public interface GrievanceCategoryService {

    GrievanceCategory addCategory(GrievanceCategory category);

    List<GrievanceCategory> getAllCategories();

    GrievanceCategory getCategoryById(Long id);

    GrievanceCategory updateCategory(Long id, GrievanceCategory category);

    List<GrievanceCategory> searchByCategoryName(String keyword);
}
