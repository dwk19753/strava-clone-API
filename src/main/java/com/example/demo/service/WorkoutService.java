package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Workout;
import com.example.demo.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Optional<Workout> getWorkoutById(Long id) {
        return workoutRepository.findById(id);
    }

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout updateWorkout(Long id, Workout workout) {
        if (workoutRepository.existsById(id)) {
            workout.setId(id);
            return workoutRepository.save(workout);
        }
        return null;  // or throw an exception
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}

