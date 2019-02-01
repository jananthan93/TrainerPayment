package com.sgic.trainer.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sgic.trainer.enums.PaymentStatus;

@Entity
@Table(name = "training_schedule", schema = "payment")
public class TrainingSchedule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1980239290620103991L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String trainingTopic;
	private Date date;
	private Time totalCoveredhours;
	private PaymentStatus status;
	private Double amounToPaid;
	
	@ManyToOne
	@JoinColumn(name = "trainer_id")
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
