package com.ServiceProviderPlatform.Service_Provider_Platform_API.service;

import com.ServiceProviderPlatform.Service_Provider_Platform_API.dto.TrainerDTO;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.exception.CustomException;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.model.Trainer;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.repository.TrainerRepository;
import com.ServiceProviderPlatform.Service_Provider_Platform_API.service.Mapper.TrainerDTOMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final TrainerDTOMapper trainerDTOMapper;

    public Optional<Trainer> findTrainerById(Long id){
        try{
            return trainerRepository.findById(id);
        } catch (Exception e) {
            throw new CustomException("An error occurred while finding the trainer.", e);
        }
    }
    @Transactional
    public TrainerDTO saveTrainer(Trainer trainer){
        try{
            Trainer savedTrainer = trainerRepository.save(trainer);
            return trainerDTOMapper.apply(savedTrainer);
        } catch (Exception e) {
            throw new CustomException("An error occurred while updating the trainer.", e);
        }
    }
}
