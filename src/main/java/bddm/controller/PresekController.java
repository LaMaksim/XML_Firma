package bddm.controller;

import bddm.client.IzvodClient;
import bddm.dto.soap.DTOPresekZaglavlje;
import bddm.dto.soap.DTOPresekZahtev;
import bddm.service.PresekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;
import java.awt.*;

@Controller
public class PresekController {

    @Autowired
    private PresekService presekService;

    @RequestMapping(value = "/presek",
                method = RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON,
                produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<DTOPresekZaglavlje> presek(@RequestBody DTOPresekZahtev dto) {
        DTOPresekZaglavlje retVal = null;

        retVal = presekService.requirePresek(dto);

        return new ResponseEntity<DTOPresekZaglavlje>(retVal, HttpStatus.OK);
    }
}
