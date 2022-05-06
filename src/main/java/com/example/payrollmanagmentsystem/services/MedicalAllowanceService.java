package com.example.payrollmanagmentsystem.services;

import com.example.payrollmanagmentsystem.domain.MedicalAllowance;
import com.example.payrollmanagmentsystem.dto.MedicalAllowanceDTO;
import com.example.payrollmanagmentsystem.repo.MedicalAllowanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalAllowanceService {

    @Autowired
    private MedicalAllowanceRepo medicalAllowanceRepo;

    public List<MedicalAllowanceDTO> getMedicalAllowance(int id){
        return medicalAllowanceRepo.findAll()
                .stream()
                .map(medicalAllowance -> convertEntityToDTO(medicalAllowance, id))
                .collect(Collectors.toList());
    }

    private MedicalAllowanceDTO convertEntityToDTO(MedicalAllowance medicalAllowance, int id){
        if(id == medicalAllowance.getEmployee().getId()) {
            MedicalAllowanceDTO medicalAllowanceDTO = new MedicalAllowanceDTO();
            medicalAllowanceDTO.setId(medicalAllowance.getEmployee().getId());
            medicalAllowanceDTO.setEmpName(medicalAllowance.getEmployee().getEmpName());
            medicalAllowanceDTO.setAmount(medicalAllowance.getAmount());
            return medicalAllowanceDTO;
        }
        return null;
    }
}
