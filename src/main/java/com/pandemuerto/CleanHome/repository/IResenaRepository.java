package com.pandemuerto.CleanHome.repository;

import com.pandemuerto.CleanHome.model.entity.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Integer> {
}
