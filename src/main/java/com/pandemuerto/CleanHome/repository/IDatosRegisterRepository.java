package com.pandemuerto.CleanHome.repository;


import com.pandemuerto.CleanHome.model.entity.DatosRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDatosRegisterRepository   extends JpaRepository<DatosRegister,Long>  {
}
