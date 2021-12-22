package com.example.testFabrica.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testFabrica.Model.Cliente;
import com.example.testFabrica.Model.Juego;

public interface JuegoRepository extends JpaRepository <Juego,Integer>{
	
}
