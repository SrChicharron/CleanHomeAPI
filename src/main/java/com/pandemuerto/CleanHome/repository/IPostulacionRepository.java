package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostulacionRepository extends JpaRepository<Postulacion,Integer> {
    List<Postulacion> findAllByPublicacionId(int idPublicacion);
    List<Postulacion> findAllByClienteId(int idCliente);
    List<Postulacion> findAllByEmpleadoId(int idEmpleado);
}
