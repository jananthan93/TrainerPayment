package com.sgic.trainer.service;

import java.util.List;

import com.sgic.trainer.entity.Payment;
import com.sgic.trainer.entity.TrainingSchedule;

public interface PaymentService {
	
	public boolean addPayment(Payment payment,TrainingSchedule trainingSchedule);
	
	List<Payment> getAllPayments();
	
	public boolean editPayment(Payment payment,TrainingSchedule trainingSchedule,Integer id );
	
	public boolean deletePayment(Integer id);
	
	
	
}
