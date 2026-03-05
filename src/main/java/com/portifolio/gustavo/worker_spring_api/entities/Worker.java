package com.portifolio.gustavo.worker_spring_api.entities;

import com.portifolio.gustavo.worker_spring_api.entities.enums.WorkerLevel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_workers")
public class Worker {

    // BASIC ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private WorkerLevel level;

    @Column(name = "base_salary")
    private Double baseSalary;

    // ASSOCIATIONS
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<HourContract> hourContractList = new ArrayList<>();

    // CONSTRUCTORS
    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract(HourContract contract) {
        hourContractList.add(contract);
        contract.setWorker(this);
    }

    public void removeContract(HourContract contract) {
        hourContractList.remove(contract);
        contract.setWorker(null);
    }

    // BUSINESS RULE
    public Double income(Integer year, Integer month) {
        double sum = baseSalary;
        for (HourContract contract : hourContractList) {
            if(year == contract.getDate().getYear() && month == contract.getDate().getMonthValue()) {
                sum += contract.totalValue();
            }
        }
        return sum;
    }

    // EQUALS AND HASHCODE
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
