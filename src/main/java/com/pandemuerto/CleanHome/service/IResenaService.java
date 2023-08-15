package com.pandemuerto.CleanHome.service;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Resena;

import java.util.List;

public interface IResenaService {

    Resena addResena(Resena resena);

    Resena updateResena(Resena resena);

    MessageResponseBean deleteResena(int idResena);

    List<Resena> getResenaByEvaluado(int idEvaluado);

    List<Resena> getResenaByEvaluador(int idEvaluador);

    List<Resena> getResenaByPublicacion(int idPublicacion);
}
