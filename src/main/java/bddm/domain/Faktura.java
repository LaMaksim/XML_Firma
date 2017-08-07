package bddm.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Faktura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FAK")
    @SequenceGenerator(name = "SEQ_FAK", sequenceName = "SEQ_FAKTURA", allocationSize = 1)
    private Long id;

    @Column(name = "FAK_NAZIV", nullable = false)
    private String dobavljacNaziv;

    @Column(name = "FAK_ADRESA", nullable = false)
    private String dobavljacAdresa;

    @Column(name = "FAK_PIB", nullable = false)
    private String dobavljacPIB;

    @Column(name = "FAK_RACUN", nullable = false)
    private String dobavljacRacun;

    @Column(name = "FAK_DATUM", nullable = false)
    private Date datum;

    @Column(name =  "FAK_VREDNOST", nullable = false)
    private double vrednost;

    @Column(name = "FAK_POREZ", nullable = false)
    private double porez;

    @Column(name = "FAK_VALUTA", nullable = false)
    private String valuta;

    @Column(name = "FAK_SVRHA", nullable = false)
    private String svrhaUplate;

    public Faktura() {}

    public Faktura(String dobavljacNaziv, String dobavljacAdresa, String dobavljacPIB, String dobavljacRacun, Date datum, Double vrednost, Double porez, String valuta, String svrhaUplate) {
        this.dobavljacNaziv = dobavljacNaziv;
        this.dobavljacAdresa = dobavljacAdresa;
        this.dobavljacPIB = dobavljacPIB;
        this.dobavljacRacun = dobavljacRacun;
        this.datum = datum;
        this.vrednost = vrednost;
        this.porez = porez;
        this.valuta = valuta;
        this.svrhaUplate = svrhaUplate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDobavljacRacun() {
        return dobavljacRacun;
    }

    public void setDobavljacRacun(String dobavljacRacun) {
        this.dobavljacRacun = dobavljacRacun;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public double getPorez() {
        return porez;
    }

    public void setPorez(double porez) {
        this.porez = porez;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getSvrhaUplate() {
        return svrhaUplate;
    }

    public void setSvrhaUplate(String svrhaUplate) {
        this.svrhaUplate = svrhaUplate;
    }
}
