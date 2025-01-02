package com.sample.employeemanagement.repository;

import com.sample.employeemanagement.dto.DepartmentDTO;
import com.sample.employeemanagement.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findByName(String name);
    Optional<DepartmentDTO> getByName(String name);
}
