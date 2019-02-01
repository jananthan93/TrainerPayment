package com.sgic.trainer.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "payment", name = "payment")
public class Payment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3323930356795011743L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double amount;
	private Date dateOfPayment;
	private Integer invoiceNo;
	
	@ManyToOne
	@JoinColumn(name = "trainingSchedule_id")
	private TrainingSchedule trainingSchedule;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Integer getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public TrainingSchedule getTrainingSchedule() {
		return trainingSchedule;
	}

	public void setTrainingSchedule(TrainingSchedule trainingSchedule) {
		this.trainingSchedule = trainingSchedule;
	}

	
	
}
