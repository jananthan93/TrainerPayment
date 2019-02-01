package com.sgic.trainer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sgic.trainer.enums.PaymentStatus;


@Entity
@Table(name = "status", schema = "payment")
public class Status implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3868521619690611362L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 @Enumerated(EnumType.STRING)
  
	  @Column(name = "status", length = 60)
	  private PaymentStatus paymentStatus;
		 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	 
	 
}
