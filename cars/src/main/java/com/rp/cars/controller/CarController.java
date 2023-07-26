package com.rp.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import com.rp.cars.model.Cars;
import com.rp.cars.service.CarService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
    CarService carService;

    @GetMapping("/test")
    public String console() {
        return ("Working perfectly ");
    }

    @GetMapping("/cars")
    public List<Cars> getAllCars(){
        return carService.getAllCars();        
    }
    
    @GetMapping("/cars/{id}")
    public Cars getCarById(@PathVariable int id){
        return carService.getCarById(id);
    }  

    @PostMapping("/cars")
    public Cars createCar(@RequestBody Cars car){
        return carService.createCar(car);
    }
    
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {
        try {
            carService.deleteCar(id);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete the book", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/cars/{id}")
    public ResponseEntity<String> updateCar(@PathVariable int id, @RequestBody Cars updatedCar) {
        try {
            Cars updatedCarResult = carService.updateCar(id, updatedCar);
            if (updatedCarResult != null) {
                return new ResponseEntity<>("Car updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Car with the given ID not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update the car", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/greet")
	public String sayHello() {
		return ("Hello Cars lover");
	}
}
