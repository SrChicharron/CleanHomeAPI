package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado,Integer> {
}
