package com.sgic.trainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.trainer.dto.PaymentInitiationDto;
import com.sgic.trainer.dto.PaymentInitiationSaveDto;
import com.sgic.trainer.mapper.PaymentInitiationDtoMapper;
import com.sgic.trainer.mapper.PaymentInitiationMapper;
import com.sgic.trainer.service.PaymentInitiationService;
import com.sgic.trainer.service.TrainerService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TrainingScheduleController {
	@Autowired
	private PaymentInitiationService initiationService;
	@Autowired
	private TrainerService trainerService;

	@PostMapping("/paymentInitiate")
	public HttpStatus addPaymentInitiation(@RequestBody PaymentInitiationSaveDto paymentInitiationSaveDto) {
		if (initiationService.addPaymentInitiation(PaymentInitiationDtoMapper.mapPaymentInitiationSaveDtoToTrainingSchedule(paymentInitiationSaveDto),
				trainerService.getById(paymentInitiationSaveDto.getTrainer()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/paymentInitiate")
	public ResponseEntity<List<PaymentInitiationDto>> getTrainingSchedule() {
		return new ResponseEntity<>(PaymentInitiationMapper.mapTrainingScheduleListToPaymentInitiationDtoList(initiationService.getAllPaymentInitiation()), HttpStatus.OK);

	}
//
//	@PutMapping("/paymentInitiate/{id}")
//	public HttpStatus editPaymentInitiation(@RequestBody TrainingSchedule initiatePayment, @PathVariable Integer id) {
//
//	}

}
