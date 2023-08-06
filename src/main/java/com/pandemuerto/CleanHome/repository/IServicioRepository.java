package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioRepository extends JpaRepository<Servicio, Long> {
}
