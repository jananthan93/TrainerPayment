package com.sgic.trainer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.trainer.entity.TrainingSchedule;

public interface PaymentInitiationRepository extends JpaRepository<TrainingSchedule, Integer> {
	TrainingSchedule findTrainingScheduleById(Integer id);

	@Query("SELECT ts FROM TrainingSchedule ts Order by ts.date desc")
	List<TrainingSchedule> findTrainingScheduleOrderByDateDesc();

}
