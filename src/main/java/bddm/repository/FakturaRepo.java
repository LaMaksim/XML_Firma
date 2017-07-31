package bddm.repository;

import bddm.domain.Faktura;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;

import java.util.Date;
import java.util.List;

public interface FakturaRepo extends Repository<Faktura, Long> {

    public Faktura save(Faktura fkt);

    public List<Faktura> findAll();

    public Faktura findById(Long id);

    public List<Faktura> findByDobavljacNaziv(String nzv);

    public List<Faktura> findByDobavljacPIB(String PIB);

    public List<Faktura> findByDobavljacRacun(String racun);

    public List<Faktura> findByDatum(Date date);

    public List<Faktura> findByValuta(String valuta);

    @Modifying
    public void deleteById(Long id);

    @Modifying
    public void delete(Faktura fkt);
}
