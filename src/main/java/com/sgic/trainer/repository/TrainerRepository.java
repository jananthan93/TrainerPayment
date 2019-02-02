package com.sgic.trainer.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.trainer.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
  
}
