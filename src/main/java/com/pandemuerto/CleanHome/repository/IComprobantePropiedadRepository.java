package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.ComprobantePropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComprobantePropiedadRepository extends JpaRepository<ComprobantePropiedad, Integer> {

    void deleteAllByIdPropiedad(Integer idPropiedad);
}
