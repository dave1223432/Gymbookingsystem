package com.example.gymmanagementlist.Service;

import com.example.gymmanagementlist.Domain.Gym;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GymService {
    Gym saveGym(Gym gym);
    Gym getGymById(long Id);
    List<Gym> getAllGym();
    Gym updateGymRecord (Gym gym);
    void deleteGym (long Id);

}
