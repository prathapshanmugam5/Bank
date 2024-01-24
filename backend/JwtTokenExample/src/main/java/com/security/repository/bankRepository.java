package com.security.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.security.configs.entity.Bank;

public interface bankRepository extends JpaRepository<Bank, Integer> {
	
}
