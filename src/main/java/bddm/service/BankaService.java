package bddm.service;

import bddm.domain.Banka;

import java.util.List;

public interface BankaService {

    Banka save(Banka bnk);

    List<Banka> getAll();


}
