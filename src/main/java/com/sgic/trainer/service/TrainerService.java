package com.sgic.trainer.service;
import java.util.List;
import com.sgic.trainer.entity.Trainer;

public interface TrainerService {
	List<Trainer> getAllTrainer();
	
	boolean createTrainer (Trainer trainer);

	boolean deleteTrainer(Integer id);

	boolean updateTrainer(Trainer trainer, Integer id);
	
	Trainer getById(Integer id);

}
