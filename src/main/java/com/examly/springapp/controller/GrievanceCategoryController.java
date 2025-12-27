package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.service.GrievanceCategoryService;

@RestController
@RequestMapping("/api/grievance-categories")
public class GrievanceCategoryController {

    @Autowired
    private GrievanceCategoryService grievanceCategoryService;

    @PostMapping
    public ResponseEntity<GrievanceCategory> addCategory(
            @RequestBody GrievanceCategory category) {

        return new ResponseEntity<>(
                grievanceCategoryService.addCategory(category),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GrievanceCategory>> getAllCategories() {
        List<GrievanceCategory> list = grievanceCategoryService.getAllCategories();
        return list.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrievanceCategory> getCategoryById(@PathVariable Long id) {
        GrievanceCategory category = grievanceCategoryService.getCategoryById(id);
        return category == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrievanceCategory> updateCategory(
            @PathVariable Long id,
            @RequestBody GrievanceCategory category) {

        GrievanceCategory updated =
                grievanceCategoryService.updateCategory(id, category);

        return updated == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(updated);
    }

    // Search (Day 11)
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<GrievanceCategory>> searchCategories(
            @PathVariable String keyword) {

        List<GrievanceCategory> result =
                grievanceCategoryService.searchByCategoryName(keyword);

        return ResponseEntity.ok(result);
    }
}
