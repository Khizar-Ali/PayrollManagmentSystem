package com.example.payrollmanagmentsystem.web;

import com.example.payrollmanagmentsystem.domain.Leave;
import com.example.payrollmanagmentsystem.dto.LeaveDTO;
import com.example.payrollmanagmentsystem.exception.UserNotFoundException;
import com.example.payrollmanagmentsystem.repo.LeaveRepo;
import com.example.payrollmanagmentsystem.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class LeaveResponse {
    @Autowired
    private LeaveRepo leaveRepo;

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/leave")
    public List<Leave> retrieveAllUsers(){
        return leaveRepo.findAll();
    }

    @GetMapping("/leave/{id}")
    public Optional<Leave> retrieveUser(@PathVariable int id){
        Optional<Leave> user = leaveRepo.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id-"+ id);

        return user;
    }
    @GetMapping("/employee-leave")
    public List<LeaveDTO> retrieveAllLeave(@RequestParam int id){
        List<LeaveDTO> leaveDTOS = leaveService.getAllLeave(id);
        return leaveDTOS;
    }

    @PostMapping("/leave")
    public ResponseEntity<Object> createUser(@RequestBody Leave leave){
        Leave savedUser = leaveRepo.save(leave);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/leave/{id}")
    public void deleteUser(@PathVariable int id){
        leaveRepo.deleteById(id);

   /* if(user==null)
         throw new UserNotFoundException("id-"+ id);*/
    }

}
