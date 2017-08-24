package bddm.util;

import bddm.domain.Faktura;
import bddm.domain.Firma;
import bddm.dto.rest.DTO_FakturaZaglavlje;
import bddm.dto.soap.DTOUplatnica;
import bddm.repository.FirmaRepo;
import bddm.service.FirmaService;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Convertor {

    @Autowired
    private FirmaRepo firmaRepo;

    private static Convertor ourInstance = new Convertor();

    public static Convertor getInstance() {
        return ourInstance;
    }

    private Convertor() {
    }

    public Faktura DTOtoFaktura(DTO_FakturaZaglavlje zg) {
        Faktura retVal = new Faktura();

        retVal.setDobavljacNaziv(zg.getDobavljacNaziv());
        retVal.setDobavljacAdresa(zg.getDobavljacAdresa());
        retVal.setDobavljacPIB(zg.getDobavljacPIB());
        retVal.setDobavljacRacun(zg.getDobavljacRacun());
        retVal.setDatum(zg.getDatumRacuna());
        retVal.setVrednost(zg.getVrednostUkupno());
        retVal.setPorez(zg.getVrednostPorez());
        retVal.setValuta(zg.getOznakaValute());

        retVal.setSvrhaUplate("GENERISANA SVRHA UPLATE");

        return retVal;
    }

    /*
        Model zaduzenja, model odobrenja, poziv na broj odobrenja i zaduzenja,
        hitnost i svrha uplate (opciono) se rucno ubacuju.
     */
    public DTOUplatnica FakturaToDTOUplatnica(Faktura fk) {
        Firma ja = firmaRepo.findByJa(true);
        DTOUplatnica retVal = new DTOUplatnica();

        retVal.setDuznikNaziv(ja.getNaziv());
        retVal.setSvrhaPlacanja(fk.getSvrhaUplate());
        retVal.setPrimalacNaziv(fk.getDobavljacNaziv());
        retVal.setDatumUplate(this.DateToXMLGregorian(new Date())); //VALJA LI????
        retVal.setDatumValute(this.DateToXMLGregorian(new Date()));
        retVal.setDuznikRacun(ja.getBrojRacuna());
        retVal.setRacunPoverioca(fk.getDobavljacRacun());
        retVal.setIznos(fk.getVrednost());

        return retVal;
    }


    //konverzija vremena, ne znam da li valja
    public XMLGregorianCalendar DateToXMLGregorian(Date date) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTimeZone(TimeZone.getDefault());
        c.setTime(date);
        XMLGregorianCalendar xml = null;
        try {
            xml = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return xml;
    }

    public Date XMLGregorianToDate(XMLGregorianCalendar xml) {
        return xml.toGregorianCalendar().getTime();
    }

    public DTOUplatnica purge(DTOUplatnica dtoUplatnica) {
        String duznikNaziv = dtoUplatnica.getDuznikNaziv().split("[\\r\\n]+")[0];
        String primalacNaziv = dtoUplatnica.getPrimalacNaziv().split("[\\r\\n]+")[0];

        dtoUplatnica.setDuznikNaziv(duznikNaziv);
        dtoUplatnica.setPrimalacNaziv(primalacNaziv);

        return dtoUplatnica;
    }
}
