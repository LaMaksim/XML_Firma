package bddm.service;

import bddm.domain.Faktura;

import java.util.List;

public interface FakturaService {

    Faktura save(Faktura fkt);

    List<Faktura> getAll();
}
