package com.example.SprinBootMysql.dao;

import com.example.SprinBootMysql.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Cars, Integer> {
    List<Cars> findByCarName(String name);
    List<Cars> findByCarBrand(String name);
    List<Cars> findByCarModel(String name);
    List<Cars> findByCarVersion(String name);
    List<Cars> findByTransmission(String name);
    List<Cars> findByCountry(String name);
    List<Cars> findByYear(String name);
    List<Cars> findByAmount(String name);
}
