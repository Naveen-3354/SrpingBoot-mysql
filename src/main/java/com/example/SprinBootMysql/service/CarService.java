package com.example.SprinBootMysql.service;

import com.example.SprinBootMysql.dao.CarRepository;
import com.example.SprinBootMysql.model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Cars saveCars(Cars cars){
        return carRepository.save(cars);
    }

    public List<Cars> getAllCars(){
        return carRepository.findAll();
    }

    public Cars updateCar(int id, Cars cars){
        Optional<Cars> oldCar = carRepository.findById(id);
        oldCar.get().setCarName(cars.getCarName());
        oldCar.get().setCarBrand(cars.getCarBrand());
        oldCar.get().setCarModel(cars.getCarModel());
        oldCar.get().setCarVersion(cars.getCarVersion());
        oldCar.get().setTransmission(cars.getTransmission());
        oldCar.get().setCountry(cars.getCountry());
        oldCar.get().setYear(cars.getYear());
        oldCar.get().setAmount(cars.getAmount());
        return carRepository.save(oldCar.get());
    }

    public String delateCar(int id){
        carRepository.deleteById(id);
        return "Deleted";
    }

}
