package com.sgic.trainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.trainer.entity.Trainer;
import com.sgic.trainer.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	TrainerRepository trainerRepository;

	@Override
	public List<Trainer> getAllTrainer() {
		return trainerRepository.findAll();
	}

	@Override
	public boolean createTrainer(Trainer trainer) {
		trainerRepository.save(trainer);
		return true;
	}

	@Override
	public boolean deleteTrainer(Integer id) {
		trainerRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean updateTrainer(Trainer trainer, Integer id) {
		if (trainerRepository.getOne(id) != null) {
			trainer.setId(id);
			trainerRepository.save(trainer);
			return true;
		}
		return false;
	}

	@Override
	public Trainer getById(Integer id) {
		return trainerRepository.findById(id).orElse(null);
	}
}
