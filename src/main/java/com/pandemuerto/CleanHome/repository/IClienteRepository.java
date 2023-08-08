package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Usuario,Integer> {
}
