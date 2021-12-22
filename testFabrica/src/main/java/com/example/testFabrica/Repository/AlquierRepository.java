package com.example.testFabrica.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testFabrica.Model.Alquiler;

public interface AlquierRepository extends JpaRepository <Alquiler,Integer>{

}
