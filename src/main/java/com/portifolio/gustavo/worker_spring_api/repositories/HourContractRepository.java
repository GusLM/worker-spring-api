package com.portifolio.gustavo.worker_spring_api.repositories;

import com.portifolio.gustavo.worker_spring_api.entities.HourContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourContractRepository extends JpaRepository<HourContract, Long> {
}
