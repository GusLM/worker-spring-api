package com.portifolio.gustavo.worker_spring_api.config;

import com.portifolio.gustavo.worker_spring_api.entities.Department;
import com.portifolio.gustavo.worker_spring_api.entities.HourContract;
import com.portifolio.gustavo.worker_spring_api.entities.Worker;
import com.portifolio.gustavo.worker_spring_api.entities.enums.WorkerLevel;
import com.portifolio.gustavo.worker_spring_api.repositories.DepartmentRepository;
import com.portifolio.gustavo.worker_spring_api.repositories.HourContractRepository;
import com.portifolio.gustavo.worker_spring_api.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SeedingConfig implements CommandLineRunner {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private HourContractRepository hourContractRepository;


    @Transactional
    @Override
    public void run(String... args) throws Exception {


        List<Department> departmentList = Arrays.asList(
                new Department("Design"),
                new Department("Back-End"),
                new Department("Front-End"),
                new Department("Infrastructure"),
                new Department("Support")
                );

        departmentList = departmentRepository.saveAll(departmentList);

        List<Worker> workerList = List.of(
                new Worker("Alpha", WorkerLevel.MID_LEVEL, 4500.0, departmentList.getFirst()),
                new Worker("Beta", WorkerLevel.JUNIOR, 3200.0, departmentList.get(2)),
                new Worker("Gama", WorkerLevel.JUNIOR, 3200.0, departmentList.get(2)),
                new Worker("Delta", WorkerLevel.SENIOR, 7500.0, departmentList.get(1)),
                new Worker("Épsilon", WorkerLevel.MID_LEVEL, 4500.0, departmentList.get(3))
        );

        workerList = workerRepository.saveAll(workerList);

        HourContract contract1 = new HourContract(LocalDate.of(2025, 8, 20), 120.0, 20);
        HourContract contract2 = new HourContract(LocalDate.of(2025, 8, 13), 80.0, 18);
        HourContract contract3 = new HourContract(LocalDate.of(2025, 8, 25), 80.0, 30);
        HourContract contract4 = new HourContract(LocalDate.of(2025, 8, 25), 180.0, 30);
        HourContract contract5 = new HourContract(LocalDate.of(2025, 8, 25), 120.0, 30);

        workerList.getFirst().addContract(contract1);
        workerList.get(1).addContract(contract2);
        workerList.get(2).addContract(contract3);
        workerList.get(3).addContract(contract4);
        workerList.get(4).addContract(contract5);
    }
}
