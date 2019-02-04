package com.sgic.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.trainer.entity.TrainingSchedule;

public interface PaymentInitiationRepository extends JpaRepository<TrainingSchedule, Integer>{
	TrainingSchedule findTrainingScheduleById(Integer id);
}
