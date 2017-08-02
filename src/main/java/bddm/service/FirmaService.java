package bddm.service;

import bddm.domain.Firma;

import java.util.List;

public interface FirmaService {

    Firma save(Firma frm);

    Firma getMojaFirma();
    List<Firma> getAll();
}
