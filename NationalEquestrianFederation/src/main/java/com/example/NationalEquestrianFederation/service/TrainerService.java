package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.ITrainerService;
import com.example.NationalEquestrianFederation.model.Trainer;
import com.example.NationalEquestrianFederation.repository.ITrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainerService implements ITrainerService {

    private final ITrainerRepository trainerRepository;

    @Override
    public List<Trainer> getTrainers(Integer horseClub) {
        return trainerRepository.findTrainersByHorseClub(horseClub);
    }

    @Override
    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public void deletedTrainer(Integer trainerId) {
        trainerRepository.deleteTrainer(trainerId);
    }
}
