package com.sgic.trainer.mapper;

import com.sgic.trainer.dto.PaymentSaveDto;
import com.sgic.trainer.entity.Payment;
import com.sgic.trainer.entity.TrainingSchedule;

public class PaymentDtoMapper {
	public static Payment mapPaymentSaveDtoToPayment(PaymentSaveDto paymentSaveDto) {
		Payment payment = new Payment();
		TrainingSchedule trainingSchedule = new TrainingSchedule();
		payment.setId(paymentSaveDto.getId());
		payment.setDateOfPayment(paymentSaveDto.getDateOfPayment());
		payment.setAmount(paymentSaveDto.getAmount());
		payment.setInvoiceNo(paymentSaveDto.getInvoiceNo());
		trainingSchedule.setId(paymentSaveDto.getTrainingSchedule());
		payment.setTrainingSchedule(trainingSchedule);
		return payment;
	}
}
