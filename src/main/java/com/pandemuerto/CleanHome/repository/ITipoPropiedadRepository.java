package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.TipoPropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPropiedadRepository extends JpaRepository<TipoPropiedad,Integer> {
}
