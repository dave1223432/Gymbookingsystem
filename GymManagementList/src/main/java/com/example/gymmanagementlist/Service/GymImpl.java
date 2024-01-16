package com.example.gymmanagementlist.Service;

import com.example.gymmanagementlist.Domain.Gym;
import com.example.gymmanagementlist.Repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymImpl implements GymService {
    @Autowired
    GymRepository gymRepository;
    @Override
    public Gym saveGym(Gym gym) {
        return gymRepository.save(gym);
    }

    @Override
    public Gym getGymById(long Id) {
        Optional<Gym> gym = gymRepository.findById(Id);
        Gym emptyGym = null;
        if (gym.isPresent()) {
            emptyGym = gym.get();
            return emptyGym;
        }
        else {
            throw new RuntimeException("Gym not found");
        }
    }

    @Override
    public List<Gym> getAllGym() {
        return gymRepository.findAll();
    }

    @Override
    public Gym updateGymRecord(Gym gym) {
        Optional<Gym> optionalGym = gymRepository.findById(gym.getId());
        if (optionalGym.isPresent()) {
            Gym updateGym = new Gym();
            updateGym.setName(gym.getName());
            updateGym.setContact(gym.getContact());
            updateGym.setGender(gym.getGender());
            updateGym.setId(gym.getId());
            updateGym.setGoals(gym.getGoals());
            updateGym.setTenure(gym.getTenure());
            gymRepository.save(updateGym);
            return updateGym;

        }
        else{
            throw new RuntimeException("Not available");
        }
    }
    @Override
    public void deleteGym(long Id) {
        gymRepository.deleteById(Id);

    }
}
