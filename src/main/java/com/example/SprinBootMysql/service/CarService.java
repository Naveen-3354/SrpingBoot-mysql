package com.example.SprinBootMysql.service;

import com.example.SprinBootMysql.dao.CarRepository;
import com.example.SprinBootMysql.model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Cars saveCars(Cars cars) {
        return carRepository.save(cars);
    }

    public List<Cars> getAllCars() {
        return carRepository.findAll();
    }

    public Cars updateCar(int id, Cars cars) {
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

    public String delateCar(int id) {
        carRepository.deleteById(id);
        return "Deleted";
    }

    public List<?> getAllCarsByAnyFields(Map<String, ?> fields) {

        if (fields.containsKey("carName")) {
            return carRepository.findByCarName((String) fields.get("carName"));
        }
        if (fields.containsKey("carBrand")) {
            return carRepository.findByCarBrand((String) fields.get("carBrand"));
        }
        if (fields.containsKey("carModel")) {
            return carRepository.findByCarModel((String) fields.get("carModel"));
        }
        if (fields.containsKey("carVersion")) {
            return carRepository.findByCarVersion((String) fields.get("carVersion"));
        }
        if (fields.containsKey("transmission")) {
            return carRepository.findByTransmission((String) fields.get("transmission"));
        }
        if (fields.containsKey("country")) {
            return carRepository.findByCountry((String) fields.get("country"));
        }
        if (fields.containsKey("year")) {
            return carRepository.findByYear((String) fields.get("year"));
        }
        if (fields.containsKey("amount")) {
            return carRepository.findByAmount((String) fields.get("amount"));
        }
        List<String> response = new ArrayList<>();
        response.add("Emplty List");
        return response;
    }
}
