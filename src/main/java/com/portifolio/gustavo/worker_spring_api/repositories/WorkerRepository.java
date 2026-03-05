package com.portifolio.gustavo.worker_spring_api.repositories;

import com.portifolio.gustavo.worker_spring_api.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
