package com.rp.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rp.cars.model.Cars;

@Repository
public interface CarDAO extends JpaRepository <Cars,Integer>{

	
	
}
