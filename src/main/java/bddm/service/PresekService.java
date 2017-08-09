package bddm.service;

import bddm.dto.soap.DTOPresekZaglavlje;
import bddm.dto.soap.DTOPresekZahtev;

public interface PresekService {

    DTOPresekZaglavlje requirePresek(DTOPresekZahtev dto);
}
