package bddm.controller;

import bddm.client.UplatnicaClient;
import bddm.domain.Faktura;
import bddm.domain.PaymentStatus;
import bddm.dto.rest.DTO_FakturaZaglavlje;
import bddm.dto.soap.DTOUplatnica;
import bddm.dto.soap.UplatnicaRequest;
import bddm.dto.soap.UplatnicaResponse;
import bddm.service.FakturaService;
import bddm.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
public class FakturaController {

    @Autowired
    private FakturaService fakturaService;

    @RequestMapping(value = "/fakture",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Faktura>> readAll() {
        List<Faktura> retVal = fakturaService.getAll();

        return new ResponseEntity<List<Faktura>>(retVal, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/fakture",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Faktura> create(@RequestBody DTO_FakturaZaglavlje dto) {
        Faktura retVal = null;
        retVal = Convertor.getInstance().DTOtoFaktura(dto);

        retVal = fakturaService.save(retVal);

        return new ResponseEntity<Faktura>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "/fakture/{id}",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Faktura> readOne(@PathVariable Long id) {
        Faktura retVal = null;
        retVal = fakturaService.getOne(id);

        return new ResponseEntity<Faktura>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "/fakture/{id}",
                method = RequestMethod.PUT,
                consumes = MediaType.APPLICATION_JSON,
                produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Faktura> update(@PathVariable Long id, @RequestBody Faktura faktura) {
        if (faktura != null && id == faktura.getId()) {
            Faktura retVal = fakturaService.save(faktura);

            return new ResponseEntity<Faktura>(retVal, HttpStatus.OK);
        }

        return new ResponseEntity<Faktura>(faktura, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/fakture/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.TEXT_PLAIN)
    public ResponseEntity<String> payOne(@PathVariable Long id, @RequestBody DTOUplatnica dtoUplatnica) {
        Faktura fk = null;
        fk = fakturaService.getOne(id);

        if (fk != null) {
            PaymentStatus status = fakturaService.pay(fk, dtoUplatnica);

            switch(status) {
                case FAILURE:
                    return new ResponseEntity<String>("NOT OK", HttpStatus.OK);
                case SUCCESS:
                    return new ResponseEntity<String>("OK", HttpStatus.OK);
                case CLEARING:
                    return new ResponseEntity<String>("WAIT CLEARING", HttpStatus.OK);
                default:
                    return new ResponseEntity<String>("NOT OK", HttpStatus.OK);
            }
        }

        return new ResponseEntity<String>("NOT FOUND", HttpStatus.NOT_FOUND);
    }


}
