package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.Trainer;

import java.util.List;

public interface ITrainerService {

    List<Trainer> getTrainers(Integer horseClub);

    Trainer addTrainer(Trainer trainer);

    void deletedTrainer(Integer trainerId);

    void editTrainer(Trainer trainer);

}
