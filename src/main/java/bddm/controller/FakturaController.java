package bddm.controller;

import bddm.domain.Faktura;
import bddm.dto.rest.DTO_FakturaZaglavlje;
import bddm.service.FakturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;
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

    @RequestMapping(value = "/fakture/{id}",
                   method = RequestMethod.GET,
                   produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Faktura> readOne(@PathVariable Long id) {
        Faktura retVal = null;
        retVal = fakturaService.getOne(id);

        return new ResponseEntity<Faktura>(retVal, HttpStatus.OK);
    }

    /*
    @RequestMapping(value = "/fakture",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Faktura> create(@RequestBody DTO_FakturaZaglavlje dto) {
        Faktura retVal
    }
    */
}
