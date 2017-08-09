package bddm.service;

import bddm.client.IzvodClient;
import bddm.dto.soap.DTOPresekZaglavlje;
import bddm.dto.soap.DTOPresekZahtev;
import bddm.repository.BankaRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class PresekServiceImpl implements PresekService {

    @Autowired
    private BankaRepo bankaRepo;

    @Autowired
    private IzvodClient client;

    @Override
    public DTOPresekZaglavlje requirePresek(DTOPresekZahtev dto) {
        int port = bankaRepo.findById(new Long(1)).getBankaPort();

        DTOPresekZaglavlje retVal = client.requirePresek(dto, port).getUplatnica();

        return retVal;
    }
}
