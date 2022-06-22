package com.example.NationalEquestrianFederation.mapper;


import com.example.NationalEquestrianFederation.dto.TrainerDto;
import com.example.NationalEquestrianFederation.model.Trainer;
import com.example.NationalEquestrianFederation.model.enums.Gender;

public class TrainerMapper {

    public static Trainer convertToTrainer(TrainerDto dto) {
        Trainer trainer = new Trainer();
        trainer.setName(dto.getName());
        trainer.setSurname(dto.getSurname());
        trainer.setDateOfBirth(dto.getDateOfBirth());
        trainer.setGender(Gender.valueOf(dto.getGender()));
        return trainer;
    }

}
