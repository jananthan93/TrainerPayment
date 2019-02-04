package com.sgic.trainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.trainer.dto.PaymentDto;
import com.sgic.trainer.dto.PaymentSaveDto;
import com.sgic.trainer.mapper.PaymentDtoMapper;
import com.sgic.trainer.mapper.PaymentMapper;
import com.sgic.trainer.service.PaymentInitiationService;
import com.sgic.trainer.service.PaymentService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentInitiationService paymentInitiationService;

	@PostMapping("/payment")
	public HttpStatus addPayment(@RequestBody PaymentSaveDto paymentSaveDto) {
		if (paymentService.addPayment(PaymentDtoMapper.mapPaymentSaveDtoToPayment(paymentSaveDto),
				paymentInitiationService.findPaymentInitiationById(paymentSaveDto.getTrainingSchedule()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/payment")
	public ResponseEntity<List<PaymentDto>> getPayments() {
		return new ResponseEntity<>(PaymentMapper.mapPaymentListToPaymentDtoList(paymentService.getAllPayments()),
				HttpStatus.OK);
	}
	
	@PutMapping("/payment/{id}")
	public HttpStatus editPayment(@RequestBody PaymentSaveDto paymentSaveDto,@PathVariable Integer id)
	{
		if (paymentService.editPayment(PaymentDtoMapper.mapPaymentSaveDtoToPayment(paymentSaveDto),
				paymentInitiationService.findPaymentInitiationById(paymentSaveDto.getTrainingSchedule()),id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	@DeleteMapping("/payment/{id}")
	public HttpStatus deletePayment(@PathVariable Integer id) {
		if(paymentService.deletePayment(id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
