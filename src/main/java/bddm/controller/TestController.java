package bddm.controller;

import bddm.domain.Banka;
import bddm.domain.Faktura;
import bddm.domain.Firma;
import bddm.service.BankaService;
import bddm.service.FakturaService;
import bddm.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import java.util.Date;

@Controller
public class TestController {

    @Autowired
    private BankaService bankaService;

    @Autowired
    private FakturaService fakturaService;

    @Autowired
    private FirmaService firmaService;

    @RequestMapping(value = "/test",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN)
    public ResponseEntity<String> test(@Context HttpServletRequest request) {
        return new ResponseEntity<String>("TEST", HttpStatus.OK);
    }


    @RequestMapping(value = "/generate",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN)
    public ResponseEntity<String> generateTestData(@Context HttpServletRequest request, @RequestParam("port") Integer port) {

        if (port != 8081 && port != 8082 && port != 8083) {

            return new ResponseEntity<String>("WRONG PORT", HttpStatus.OK);
        } else {

            boolean ja;

            ja = (port == 8081);
            Firma firma1 = new Firma();
            firma1.setNaziv("Firma8081");
            firma1.setAdresa("Adresa na localhost/8081");
            firma1.setPIB("000008081");
            firma1.setBrojRacuna("084-0000000008081-81");
            firma1.setJa(ja);
            firma1.setPort(8081);

            ja = (port == 8082);
            Firma firma2 = new Firma();
            firma2.setNaziv("Firma8082");
            firma2.setAdresa("Adresa na localhost/8082");
            firma2.setPIB("000008082");
            firma2.setBrojRacuna("084-0000000008082-82");
            firma2.setJa(ja);
            firma2.setPort(8082);

            ja = (port == 8083);
            Firma firma3 = new Firma();
            firma3.setNaziv("Firma8083");
            firma3.setAdresa("Adresa na localhost/8083");
            firma3.setPIB("000008083");
            firma3.setBrojRacuna("085-0000000008083-83");
            firma3.setJa(ja);
            firma3.setPort(8083);

            firmaService.save(firma1);
            firmaService.save(firma2);
            firmaService.save(firma3);

            Banka banka = new Banka();

            //firme 8081 i 8082 imaju banku na 8084, firma 8083 ima banku 8085
            if (port != 8083) {
                banka.setBankaNaziv("Banka8084");
                banka.setBankaPort(8084);
            } else {
                banka.setBankaNaziv("Banka8085");
                banka.setBankaPort(8085);
            }


            bankaService.save(banka);


            Faktura faktura1 = new Faktura();
            faktura1.setDobavljacNaziv("Firma8082");
            faktura1.setDobavljacAdresa("Adresa na localhost/8082");
            faktura1.setDobavljacPIB("000008082");
            faktura1.setDobavljacRacun("084-0000000008082-82");
            faktura1.setDatum(new Date());
            faktura1.setVrednost(20000.00);
            faktura1.setPorez(2000.00);
            faktura1.setValuta("DIN");
            faktura1.setSvrhaUplate("Test faktura od 8082 do 8081");

            Faktura faktura2 = new Faktura();
            faktura2.setDobavljacNaziv("Firma8083");
            faktura2.setDobavljacAdresa("Adresa na localhost/8083");
            faktura2.setDobavljacPIB("000008083");
            faktura2.setDobavljacRacun("085-0000000008083-83");
            faktura2.setDatum(new Date());
            faktura2.setVrednost(15000.00);
            faktura2.setPorez(1500.00);
            faktura2.setValuta("DIN");
            faktura2.setSvrhaUplate("Test faktura od 8083 do 8081");

            fakturaService.save(faktura1);
            fakturaService.save(faktura2);

            return new ResponseEntity<String>("TEST GENERATED", HttpStatus.OK);
        }
    }
}
