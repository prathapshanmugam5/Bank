package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.configs.entity.Credit;

public interface creditRepository extends JpaRepository<Credit, Integer> {

}
