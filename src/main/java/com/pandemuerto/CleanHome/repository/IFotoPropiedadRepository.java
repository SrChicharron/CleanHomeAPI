package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.FotoPropiedad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Transactional
@Repository
public interface IFotoPropiedadRepository extends JpaRepository<FotoPropiedad, Integer> {
    void deleteAllByIdPropiedad(Integer idPropiedad);
}
