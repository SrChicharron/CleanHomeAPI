package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPropiedadRepository extends JpaRepository<Propiedad,Integer> {
    List<Propiedad> findAllByIdUsuario(int idUsuario);
}
