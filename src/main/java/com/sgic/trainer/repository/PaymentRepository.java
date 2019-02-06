package com.sgic.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.trainer.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
