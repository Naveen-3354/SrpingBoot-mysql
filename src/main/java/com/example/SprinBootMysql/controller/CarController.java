package com.example.SprinBootMysql.controller;

import com.example.SprinBootMysql.model.Cars;
import com.example.SprinBootMysql.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CarController {
    @Autowired
    private CarService carService;
    


    @PostMapping
    public Cars addNewCar(@RequestBody Cars cars){
        return carService.saveCars(cars);
    }

    @GetMapping("/")
    public List<Cars> getAllCars(){
        return carService.getAllCars();
    }

    @PutMapping("/{id}")
    public Cars updateCar(@RequestBody Cars cars, @PathVariable int id){
        return carService.updateCar(id,cars);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable int id){
        return carService.delateCar(id);
    }
}
