package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation,Integer> {

}
