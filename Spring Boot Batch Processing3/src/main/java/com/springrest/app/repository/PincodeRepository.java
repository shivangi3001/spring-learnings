package com.springrest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.app.entity.PinCode;

@Repository
public interface PincodeRepository extends JpaRepository<PinCode, Integer> {
 
}
