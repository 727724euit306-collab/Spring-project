package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> opt = departmentRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Optional<Department> opt = departmentRepository.findById(id);
        if (opt.isPresent()) {
            Department existing = opt.get();
            existing.setDepartmentName(department.getDepartmentName());
            existing.setContactEmail(department.getContactEmail());
            existing.setContactPhone(department.getContactPhone());
            return departmentRepository.save(existing);
        }
        return null;
    }

    @Override
    public Page<Department> getDepartmentsWithPagination(int page, int size) {
        return departmentRepository.findAll(PageRequest.of(page, size));
    }
}
