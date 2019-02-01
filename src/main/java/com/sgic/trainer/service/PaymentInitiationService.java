package com.sgic.trainer.service;

import java.util.List;
import com.sgic.trainer.entity.TrainingSchedule;

public interface PaymentInitiationService {
	boolean addPaymentInitiation(TrainingSchedule trainingSchedule);

	boolean updatePaymentInitiation(TrainingSchedule trainingSchedule, Integer id);

	List<TrainingSchedule> getAllPaymentInitiation();

	boolean paymentPaid(TrainingSchedule trainingSchedule,Integer id);

	boolean paymentCompleted(TrainingSchedule trainingSchedule,Integer id);

}
