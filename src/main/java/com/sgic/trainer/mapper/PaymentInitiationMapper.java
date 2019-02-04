package com.sgic.trainer.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sgic.trainer.dto.PaymentInitiationDto;
import com.sgic.trainer.entity.TrainingSchedule;

public class PaymentInitiationMapper {
	public static PaymentInitiationDto mapTraininScheduleToPaymentInitiationDto(TrainingSchedule initiatePayment) {
		PaymentInitiationDto paymentInitiationDto = new PaymentInitiationDto();
		paymentInitiationDto.setAmounToPaid(initiatePayment.getAmounToPaid());
		paymentInitiationDto.setDate(initiatePayment.getDate());
		paymentInitiationDto.setId(initiatePayment.getId());
		paymentInitiationDto.setTotalCoveredhours(initiatePayment.getTotalCoveredhours());
		paymentInitiationDto.setTrainingTopic(initiatePayment.getTrainingTopic());
		paymentInitiationDto.setTrainer(initiatePayment.getTrainer());
		paymentInitiationDto.setStatus(initiatePayment.getStatus());
		return paymentInitiationDto;
	}

	public static List<PaymentInitiationDto> mapTrainingScheduleListToPaymentInitiationDtoList(
			List<TrainingSchedule> initiatePaymentList) {
		List<PaymentInitiationDto> paymentInitiationDtoList = new ArrayList<PaymentInitiationDto>();
		if (initiatePaymentList != null) {
			for (TrainingSchedule initiatePayment : initiatePaymentList)
				paymentInitiationDtoList.add(mapTraininScheduleToPaymentInitiationDto(initiatePayment));

		}
		return paymentInitiationDtoList;
	}
}
