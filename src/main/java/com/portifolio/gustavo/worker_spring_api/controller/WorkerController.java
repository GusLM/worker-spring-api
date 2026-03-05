package com.portifolio.gustavo.worker_spring_api.controller;

import com.portifolio.gustavo.worker_spring_api.dto.WorkerIncomeDTO;
import com.portifolio.gustavo.worker_spring_api.entities.Worker;
import com.portifolio.gustavo.worker_spring_api.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping(value = "/{id}/income/{year}/{month}")
    public WorkerIncomeDTO getWorkerIncomeDTO(
            @PathVariable Long id,
            @PathVariable Integer year,
            @PathVariable Integer month
    ) {
        Worker worker = workerRepository.findById(id).get();

        return new WorkerIncomeDTO(
                worker.getName(), worker.getDepartment().getDepartmentName(), worker.income(year, month)
        );
    }

}
