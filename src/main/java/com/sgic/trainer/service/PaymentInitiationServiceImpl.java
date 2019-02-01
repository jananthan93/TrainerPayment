package com.sgic.trainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.trainer.entity.TrainingSchedule;
import com.sgic.trainer.enums.PaymentStatus;
import com.sgic.trainer.repository.PaymentInitiationRepository;
@Service
public class PaymentInitiationServiceImpl implements PaymentInitiationService{
	@Autowired
	private PaymentInitiationRepository paymentInitiationRepository;

	@Override
	public boolean addPaymentInitiation(TrainingSchedule trainingSchedule) {
		trainingSchedule.setStatus(PaymentStatus.INITIATED);
		paymentInitiationRepository.save(trainingSchedule);
		return true;
	}

	@Override
	public boolean updatePaymentInitiation(TrainingSchedule trainingSchedule, Integer id) {
		boolean edit=false;
		if(paymentInitiationRepository.getOne(id)!=null) {
			trainingSchedule.setId(id);
			paymentInitiationRepository.save(trainingSchedule);
			edit=true;
		}
		return edit;
	}

	@Override
	public List<TrainingSchedule> getAllPaymentInitiation() {
		
		return paymentInitiationRepository.findAll();
	}

	@Override
	public boolean paymentPaid(TrainingSchedule trainingSchedule, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean paymentCompleted(TrainingSchedule trainingSchedule, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
