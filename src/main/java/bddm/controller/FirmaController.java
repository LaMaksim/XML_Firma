package bddm.controller;

import bddm.domain.Firma;
import bddm.service.FirmaService;
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
public class FirmaController {

    @Autowired
    private FirmaService firmaService;

    @RequestMapping(value = "/firme",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Firma>> readAll() {
        List<Firma> retVal = firmaService.getAll();

        return new ResponseEntity<List<Firma>>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "/firme",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Firma> create(@RequestBody Firma firma) {
        if (firma != null) {
            Firma retVal = firmaService.save(firma);

            return new ResponseEntity<Firma>(retVal, HttpStatus.OK);
        }

        return new ResponseEntity<Firma>(firma, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/firme/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Firma> readOne(@PathVariable Long id) {
        Firma retVal = null;
        retVal = firmaService.getOne(id);

        return new ResponseEntity<Firma>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "/firme/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Firma> update(@PathVariable Long id, @RequestBody Firma firma) {
        if (firma != null && id == firma.getId()) {
            Firma retVal = firmaService.save(firma);

            return new ResponseEntity<Firma>(retVal, HttpStatus.OK);
        }

        return new ResponseEntity<Firma>(firma, HttpStatus.BAD_REQUEST);
    }
}
