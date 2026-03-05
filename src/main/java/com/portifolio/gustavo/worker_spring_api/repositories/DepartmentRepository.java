package com.portifolio.gustavo.worker_spring_api.repositories;

import com.portifolio.gustavo.worker_spring_api.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
