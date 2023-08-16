package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Integer> {
    List<Resena> findAllByEvaluadoId(int idEvaluado);
    List<Resena> findAllByEvaluadorId(int idEvaluador);
    List<Resena> findAllByPublicacionId(int idPublicacion);
}
