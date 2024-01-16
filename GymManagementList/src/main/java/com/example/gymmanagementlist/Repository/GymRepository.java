package com.example.gymmanagementlist.Repository;

import com.example.gymmanagementlist.Domain.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym,Long> {

}
