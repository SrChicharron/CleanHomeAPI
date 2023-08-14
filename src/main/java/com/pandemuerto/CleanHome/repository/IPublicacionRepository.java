package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion,Integer> {
    List<Publicacion> findByTipoLimpieza(String tipoLimpieza);
}
