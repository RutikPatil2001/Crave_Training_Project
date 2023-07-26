package com.rp.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.cars.model.Cars;
import com.rp.cars.CarDAO;
@Service
public class CarService {

    

    @Autowired
    CarDAO carRepository;

    

    public List<Cars> getAllCars(){
        return carRepository.findAll();
    }


    public Cars getCarById(int id) {
        return carRepository.findById(id).get();
    }


    public Cars createCar(Cars car) {
        return carRepository.save(car);
    }
    
    public void deleteCar(int id) {
		// TODO Auto-generated method stub
		 carRepository.deleteById(id);
	}
    
    public Cars updateCar(int carId, Cars updatedCar) {

        Cars existingCar = carRepository.findById(carId).orElse(null);

        if (existingCar != null) {

            existingCar.setModel(updatedCar.getModel());

            existingCar.setPrice(updatedCar.getPrice());

            existingCar.setColour(updatedCar.getColour());

            return carRepository.save(existingCar);

        }

        return null; // Car with the specified ID not found

    }

}