package com.sgic.trainer.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sgic.trainer.dto.PaymentDto;
import com.sgic.trainer.entity.Payment;

public class PaymentMapper {
	public static PaymentDto mapPaymentToPaymentDto(Payment payment) {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setId(payment.getId());
		paymentDto.setAmount(payment.getAmount());
		paymentDto.setDateOfPayment(payment.getDateOfPayment());
		paymentDto.setInvoiceNo(payment.getInvoiceNo());
		paymentDto.setTrainingSchedule(payment.getTrainingSchedule());
		return paymentDto;

	}

	public static List<PaymentDto> mapPaymentListToPaymentDtoList(List<Payment> paymentList) {
		List<PaymentDto> paymentDtoList = new ArrayList<PaymentDto>();
		if (paymentList != null) {
			for (Payment payment : paymentList)
				paymentDtoList.add(mapPaymentToPaymentDto(payment));
		}
		return paymentDtoList;
	}
}
