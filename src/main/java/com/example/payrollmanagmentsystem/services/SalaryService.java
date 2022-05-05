package com.example.payrollmanagmentsystem.services;

import com.example.payrollmanagmentsystem.domain.Salary;
import com.example.payrollmanagmentsystem.dto.SalaryDTO;
import com.example.payrollmanagmentsystem.repo.SalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepo salaryRepo;

    public List<SalaryDTO> getAllSalary(int id){
        return salaryRepo.findAll()
                .stream()
                .map(salary -> convertEntityToDTO(salary, id))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

    }

    private SalaryDTO convertEntityToDTO(Salary salary, int id){
        if(id == salary.getEmployee().getId()) {
            SalaryDTO salaryDTO = new SalaryDTO();
            salaryDTO.setId(salary.getEmployee().getId());
            salaryDTO.setEmpName(salary.getEmployee().getEmpName());
            salaryDTO.setCreatedDate(salary.getCreatedDate());
            return salaryDTO;
        }
        return null;
    }

}
