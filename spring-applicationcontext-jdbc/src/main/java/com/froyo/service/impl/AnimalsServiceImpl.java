package com.froyo.service.impl;

import com.froyo.model.entity.AnimalsEntity;
import com.froyo.repository.AnimalsRepository;
import com.froyo.service.AnimalsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AnimalsServiceImpl implements AnimalsService {

    private final AnimalsRepository animalsRepository;

    @Override
    public Optional<AnimalsEntity> find(Integer id) {
        return animalsRepository.find(id);
    }

    @Override
    public void addAnimal(AnimalsEntity animalsEntity) {
        animalsRepository.addAnimal(animalsEntity);
    }

    @Override
    public void editAnimal(AnimalsEntity animalsEntity) {
        animalsRepository.editAnimal(animalsEntity);
    }

    @Override
    public void deleteAnimal(int id) {
        animalsRepository.deleteAnimal(id);
    }

    @Override
    public List<AnimalsEntity> findAll() {
        return animalsRepository.findAll();
    }

}
