package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.FotoPropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotoPropiedadRepository extends JpaRepository<FotoPropiedad, Integer> {
}
