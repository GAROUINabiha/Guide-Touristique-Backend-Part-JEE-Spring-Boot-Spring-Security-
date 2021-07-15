package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Monument;
public interface MonumentRepository extends JpaRepository<Monument,Integer> {

}
