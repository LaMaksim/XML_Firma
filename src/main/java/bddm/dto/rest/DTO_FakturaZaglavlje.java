package bddm.dto.rest;

import java.util.Date;
import java.util.List;

/**
 * Created by maksim on 22-Jul-17.
 */
public class DTO_FakturaZaglavlje {

    protected String id;
    protected String dobavljacNaziv;
    protected String dobavljacAdresa;
    protected String dobavljacPIB;
    protected String kupacNaziv;
    protected String kupacAdresa;
    protected String kupacPIB;
    protected long rbrRacuna;
    protected Date datumRacuna;
    protected double vrednostRobe;
    protected double vrednostUsluga;
    protected double vrednostUkupno;
    protected double vrednostRabat;
    protected double vrednostPorez;
    protected String oznakaValute;
    protected double ukupno;
    protected String dobavljacRacun;
    protected Date datumValute;
    protected List<DTO_FakturaZaglavlje> stavke;

    public DTO_FakturaZaglavlje() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDobavljacNaziv() {
        return dobavljacNaziv;
    }

    public void setDobavljacNaziv(String dobavljacNaziv) {
        this.dobavljacNaziv = dobavljacNaziv;
    }

    public String getDobavljacAdresa() {
        return dobavljacAdresa;
    }

    public void setDobavljacAdresa(String dobavljacAdresa) {
        this.dobavljacAdresa = dobavljacAdresa;
    }

    public String getDobavljacPIB() {
        return dobavljacPIB;
    }

    public void setDobavljacPIB(String dobavljacPIB) {
        this.dobavljacPIB = dobavljacPIB;
    }

    public String getKupacNaziv() {
        return kupacNaziv;
    }

    public void setKupacNaziv(String kupacNaziv) {
        this.kupacNaziv = kupacNaziv;
    }

    public String getKupacAdresa() {
        return kupacAdresa;
    }

    public void setKupacAdresa(String kupacAdresa) {
        this.kupacAdresa = kupacAdresa;
    }

    public String getKupacPIB() {
        return kupacPIB;
    }

    public void setKupacPIB(String kupacPIB) {
        this.kupacPIB = kupacPIB;
    }

    public long getRbrRacuna() {
        return rbrRacuna;
    }

    public void setRbrRacuna(long rbrRacuna) {
        this.rbrRacuna = rbrRacuna;
    }

    public Date getDatumRacuna() {
        return datumRacuna;
    }

    public void setDatumRacuna(Date datumRacuna) {
        this.datumRacuna = datumRacuna;
    }

    public double getVrednostRobe() {
        return vrednostRobe;
    }

    public void setVrednostRobe(double vrednostRobe) {
        this.vrednostRobe = vrednostRobe;
    }

    public double getVrednostUsluga() {
        return vrednostUsluga;
    }

    public void setVrednostUsluga(double vrednostUsluga) {
        this.vrednostUsluga = vrednostUsluga;
    }

    public double getVrednostUkupno() {
        return vrednostUkupno;
    }

    public void setVrednostUkupno(double vrednostUkupno) {
        this.vrednostUkupno = vrednostUkupno;
    }

    public double getVrednostRabat() {
        return vrednostRabat;
    }

    public void setVrednostRabat(double vrednostRabat) {
        this.vrednostRabat = vrednostRabat;
    }

    public double getVrednostPorez() {
        return vrednostPorez;
    }

    public void setVrednostPorez(double vrednostPorez) {
        this.vrednostPorez = vrednostPorez;
    }

    public String getOznakaValute() {
        return oznakaValute;
    }

    public void setOznakaValute(String oznakaValute) {
        this.oznakaValute = oznakaValute;
    }

    public double getUkupno() {
        return ukupno;
    }

    public void setUkupno(double ukupno) {
        this.ukupno = ukupno;
    }

    public String getDobavljacRacun() {
        return dobavljacRacun;
    }

    public void setDobavljacRacun(String dobavljacRacun) {
        this.dobavljacRacun = dobavljacRacun;
    }

    public Date getDatumValute() {
        return datumValute;
    }

    public void setDatumValute(Date datumValute) {
        this.datumValute = datumValute;
    }

    public List<DTO_FakturaZaglavlje> getStavke() {
        return stavke;
    }

    public void setStavke(List<DTO_FakturaZaglavlje> stavke) {
        this.stavke = stavke;
    }
}
