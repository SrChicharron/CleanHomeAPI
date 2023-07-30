package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Integer> {
}
