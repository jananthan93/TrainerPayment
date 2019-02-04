package com.sgic.trainer.mapper;

import com.sgic.trainer.dto.PaymentInitiationSaveDto;
import com.sgic.trainer.entity.Trainer;
import com.sgic.trainer.entity.TrainingSchedule;

public class PaymentInitiationDtoMapper {
	public static TrainingSchedule mapPaymentInitiationSaveDtoToTrainingSchedule(
			PaymentInitiationSaveDto paymentInitiationSaveDto) {
		TrainingSchedule paymentInitiate = new TrainingSchedule();
		Trainer trainer = new Trainer();
		paymentInitiate.setId(paymentInitiationSaveDto.getId());
		paymentInitiate.setTrainingTopic(paymentInitiationSaveDto.getTrainingTopic());
		paymentInitiate.setDate(paymentInitiationSaveDto.getDate());
		paymentInitiate.setStatus(paymentInitiationSaveDto.getPaymentStatus());
		paymentInitiate.setTotalCoveredhours(paymentInitiationSaveDto.getTotalCoveredhours());
		paymentInitiate.setAmounToPaid(paymentInitiationSaveDto.getAmounToPaid());
		trainer.setId(paymentInitiationSaveDto.getTrainer());
		paymentInitiate.setTrainer(trainer);
		return paymentInitiate;
	}
}
