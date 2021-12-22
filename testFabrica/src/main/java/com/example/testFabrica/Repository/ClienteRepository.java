package com.example.testFabrica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testFabrica.Dto.ClienteDTO;
import com.example.testFabrica.Model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Integer>{
	
}
