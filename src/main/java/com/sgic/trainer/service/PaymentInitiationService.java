package com.sgic.trainer.service;

import java.util.List;

import com.sgic.trainer.entity.Trainer;
import com.sgic.trainer.entity.TrainingSchedule;

public interface PaymentInitiationService {
	boolean addPaymentInitiation(TrainingSchedule trainingSchedule, Trainer trainer);

	boolean updatePaymentInitiation(TrainingSchedule trainingSchedule, Trainer trainer, Integer id);

	List<TrainingSchedule> getAllPaymentInitiation();

	boolean paymentCompleted(TrainingSchedule trainingSchedule, Trainer trainer, Integer id);

	boolean paymentProcess(TrainingSchedule trainingSchedule, Trainer trainer, Integer id);

	TrainingSchedule findPaymentInitiationById(Integer id);
}
