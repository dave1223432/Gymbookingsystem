package com.example.gymmanagementlist.Controller.API;

import com.example.gymmanagementlist.Domain.Gym;
import com.example.gymmanagementlist.Repository.GymRepository;
import com.example.gymmanagementlist.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

public class GymAPI {
    @Autowired
    GymRepository gymRepository;

    @Autowired
    GymService gymService;
    @RequestMapping("/gym")
    @GetMapping("/gym")
    public ResponseEntity<List<Gym>> getAllGym(){
        return ResponseEntity.ok().body(gymService.getAllGym());
    }
    @GetMapping
    public ResponseEntity<Gym> getGymById(@PathVariable long id){
        return ResponseEntity.ok().body(gymService.getGymById(id));
    }
    @PostMapping("/gym")
    public ResponseEntity<Gym> saveGym(@RequestBody Gym gym){
        return ResponseEntity.ok().body(gymService.saveGym(gym));
    }
    @PutMapping("/gym/{id}")
    public ResponseEntity<Gym> updateGymRecord(@PathVariable long Id, @RequestBody Gym gym){
        return ResponseEntity.ok().body(gymService.updateGymRecord(gym));
    }
    @DeleteMapping("/gym/{id}")
    public HttpStatus deleteGym(@PathVariable long id ){
        gymService.deleteGym(id);
        return HttpStatus.OK;
    }

}
