package com.example.payrollmanagmentsystem.services;

import ch.qos.logback.classic.joran.action.LevelAction;
import com.example.payrollmanagmentsystem.domain.Employee;
import com.example.payrollmanagmentsystem.domain.Leave;
import com.example.payrollmanagmentsystem.dto.LeaveDTO;
import com.example.payrollmanagmentsystem.repo.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepo leaveRepo;

    public List<LeaveDTO> getAllLeave(int id){
        return leaveRepo.findAll()
                .stream()
                .map(leave -> convertEntitytoDTO(leave, id))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    private LeaveDTO convertEntitytoDTO(Leave leave, int id){
        if(id == leave.getEmployee().getId()) {
            LeaveDTO leaveDTO = new LeaveDTO();
            leaveDTO.setNoOfLeaves(leave.getNoOfLeaves());
            leaveDTO.setId(leave.getEmployee().getId());
            leaveDTO.setEmpName(leave.getEmployee().getEmpName());
            return leaveDTO;
        }
        return null;
    }
}

