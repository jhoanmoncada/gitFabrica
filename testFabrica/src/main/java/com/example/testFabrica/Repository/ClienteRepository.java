package com.example.testFabrica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testFabrica.Model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Integer>{

}
