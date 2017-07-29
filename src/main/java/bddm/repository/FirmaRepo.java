package bddm.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;

import bddm.domain.Firma;

import java.util.List;

public interface FirmaRepo extends Repository<Firma, Long> {

    public Firma save(Firma frm);

    public List<Firma> findAll();

    public Firma findById(Long id);

    public Firma findByPIB(String PIB);

    public Firma findByNaziv(String naziv);

    public Firma findByBrojRacuna(String brojRacuna);

    public Firma findByJa(boolean ja);

    public Firma findByPort(int port);

    @Modifying
    public void deleteById(Long id);

    @Modifying
    public void delete(Firma frm);

}
