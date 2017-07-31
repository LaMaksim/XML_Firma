package bddm.repository;

import bddm.domain.Banka;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BankaRepo extends Repository<Banka, Long> {

    public Banka save(Banka bnk);

    public List<Banka> findAll();

    public Banka findById(Long id);

    public Banka findByBankaPort(int port);

    public Banka findByBankaNaziv(String naziv);

    @Modifying
    public void deleteById(Long id);

    @Modifying
    public void delete(Banka bnk);
}
