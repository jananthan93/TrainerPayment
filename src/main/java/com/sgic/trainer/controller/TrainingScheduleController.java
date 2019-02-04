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
import com.sgic.trainer.entity.Trainer;
import com.sgic.trainer.entity.TrainingSchedule;
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
		if (initiationService.addPaymentInitiation(
				PaymentInitiationDtoMapper.mapPaymentInitiationSaveDtoToTrainingSchedule(paymentInitiationSaveDto),
				trainerService.getById(paymentInitiationSaveDto.getTrainer()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/paymentInitiate")
	public ResponseEntity<List<PaymentInitiationDto>> getTrainingSchedule() {
		return new ResponseEntity<>(PaymentInitiationMapper.mapTrainingScheduleListToPaymentInitiationDtoList(
				initiationService.getAllPaymentInitiation()), HttpStatus.OK);

	}

	@PutMapping("/paymentInitiate/{id}")
	public HttpStatus editPaymentInitiation(@RequestBody PaymentInitiationSaveDto paymentInitiationSaveDto,
			@PathVariable Integer id) {
		if (initiationService.updatePaymentInitiation(
				PaymentInitiationDtoMapper.mapPaymentInitiationSaveDtoToTrainingSchedule(paymentInitiationSaveDto),
				trainerService.getById(paymentInitiationSaveDto.getTrainer()), id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/paymentInitiate/complete/{id}")
	public HttpStatus paymentComplete(@RequestBody PaymentInitiationSaveDto paymentInitiationSaveDto,
			@PathVariable Integer id) {
		if (initiationService.paymentCompleted(
				PaymentInitiationDtoMapper.mapPaymentInitiationSaveDtoToTrainingSchedule(paymentInitiationSaveDto),
				trainerService.getById(paymentInitiationSaveDto.getTrainer()), id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/paymentInitiate/process/{id}")
	public HttpStatus paymentProcess(@RequestBody PaymentInitiationSaveDto paymentInitiationSaveDto,
			@PathVariable Integer id) {
		if (initiationService.paymentProcess(
				PaymentInitiationDtoMapper.mapPaymentInitiationSaveDtoToTrainingSchedule(paymentInitiationSaveDto),
				trainerService.getById(paymentInitiationSaveDto.getTrainer()), id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
