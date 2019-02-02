package com.sgic.trainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.trainer.entity.Trainer;
import com.sgic.trainer.entity.TrainingSchedule;
import com.sgic.trainer.enums.PaymentStatus;
import com.sgic.trainer.repository.PaymentInitiationRepository;

@Service
public class PaymentInitiationServiceImpl implements PaymentInitiationService {
	@Autowired
	private PaymentInitiationRepository paymentInitiationRepository;

	@Override
	public boolean addPaymentInitiation(TrainingSchedule trainingSchedule, Trainer trainer) {
		trainingSchedule.setStatus(PaymentStatus.INITIATED);
		trainingSchedule.setTrainer(trainer);
		paymentInitiationRepository.save(trainingSchedule);
		return true;
	}

	@Override
	public boolean updatePaymentInitiation(TrainingSchedule trainingSchedule, Trainer trainer, Integer id) {
		boolean edit = false;
		if (paymentInitiationRepository.getOne(id) != null) {
			trainingSchedule.setId(id);
			trainingSchedule.setTrainer(trainer);
			paymentInitiationRepository.save(trainingSchedule);
			edit = true;
		}
		return edit;
	}

	@Override
	public List<TrainingSchedule> getAllPaymentInitiation() {

		return paymentInitiationRepository.findAll();
	}

//	@Override
//	public boolean paymentDeposited(TrainingSchedule trainingSchedule, Trainer trainer, Integer id) {
//		if (paymentInitiationRepository.getOne(id)!=null) {
//			trainingSchedule.setStatus(PaymentStatus.DEPOSITED);
//			trainingSchedule.setTrainer(trainer);
//			paymentInitiationRepository.save(trainingSchedule);
//			return true;
//		}
//		return false;
//	}

	@Override
	public boolean paymentCompleted(TrainingSchedule trainingSchedule, Trainer trainer, Integer id) {
		if (paymentInitiationRepository.getOne(id) != null) {
			trainingSchedule.setStatus(PaymentStatus.COMPLETED);
			trainingSchedule.setTrainer(trainer);
			paymentInitiationRepository.save(trainingSchedule);
			return true;
		}
		return false;
	}

}
