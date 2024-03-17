package com.example.SprinBootMysql.dao;

import com.example.SprinBootMysql.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Cars, Integer> {
}
