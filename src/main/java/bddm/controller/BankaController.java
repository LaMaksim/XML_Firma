package bddm.controller;

import bddm.domain.Banka;
import bddm.service.BankaService;
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
public class BankaController {

    @Autowired
    private BankaService bankaService;


    @RequestMapping(value = "/banke",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Banka>> readAll() {
        List<Banka> retVal = bankaService.getAll();

        return new ResponseEntity<List<Banka>>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "/banke",
                method = RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON,
                produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Banka> create(@RequestBody Banka banka) {
        if (banka != null) {
            Banka retVal = bankaService.save(banka);

            return new ResponseEntity<Banka>(retVal, HttpStatus.OK);
        }

        return new ResponseEntity<Banka>(banka, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/banke/{id}",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Banka> readOne(@PathVariable Long id) {
        Banka retVal = null;
        retVal = bankaService.getOne(id);

        return new ResponseEntity<Banka>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "/banke/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Banka> update(@PathVariable Long id, @RequestBody Banka banka) {
        if (banka != null && id == banka.getId()) {
            Banka retVal = bankaService.save(banka);

            return new ResponseEntity<Banka>(retVal, HttpStatus.OK);
        }

        return new ResponseEntity<Banka>(banka, HttpStatus.BAD_REQUEST);
    }
}
