package com.sgic.trainer.dto;

import java.sql.Time;
import java.util.Date;

import com.sgic.trainer.entity.Trainer;
import com.sgic.trainer.enums.PaymentStatus;

public class PaymentInitiationDto {
	private Integer id;
	private String trainingTopic;
	private Date date;
	private Time totalCoveredhours;
	private PaymentStatus status;
	private Double amounToPaid;
	private Trainer trainer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrainingTopic() {
		return trainingTopic;
	}
	public void setTrainingTopic(String trainingTopic) {
		this.trainingTopic = trainingTopic;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTotalCoveredhours() {
		return totalCoveredhours;
	}
	public void setTotalCoveredhours(Time totalCoveredhours) {
		this.totalCoveredhours = totalCoveredhours;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	public Double getAmounToPaid() {
		return amounToPaid;
	}
	public void setAmounToPaid(Double amounToPaid) {
		this.amounToPaid = amounToPaid;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	
}
