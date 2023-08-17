package com.pandemuerto.CleanHome.service;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Postulacion;

import java.util.List;

public interface IPostulacionService {
    Postulacion addPostulacion(Postulacion postulacion);
    List<Postulacion> getPostulacionesByPublicacion(int idPublicacion);
    List<Postulacion> getPostulacionesByCliente(int idCliente);
    List<Postulacion> getPostulacionesByEmpleado(int idEmpleado);
    Postulacion updatePostulacion(Postulacion postulacion);
    MessageResponseBean deletePostulacion(int idPostulacion);
    Postulacion findPostulacionById(int id);
}
