package bddm.domain;

import javax.persistence.*;

@Entity
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FRM")
    @SequenceGenerator(name = "SEQ_FRM", sequenceName = "SEQ_FIRMA", allocationSize = 1)
    @Column(name = "FRM_ID")
    private Long id;

    @Column(name = "FRM_NAZIV", nullable = false)
    private String naziv;

    @Column(name = "FRM_ADRESA", nullable = true)
    private String adresa;

    @Column(name = "FRM_PIB", nullable = false)
    private String PIB;

    @Column(name = "FRM_BR_RACUNA", nullable = false)
    private String brojRacuna;

    @Column(name = "FRM_JA", nullable = false)
    private boolean ja;

    @Column(name = "FRM_PORT", nullable = false)
    private int port;

    public Firma() {}

    public Firma(String naziv, String adresa, String PIB, String brojRacuna, boolean ja, int port) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.PIB = PIB;
        this.brojRacuna = brojRacuna;
        this.ja = ja;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public boolean isJa() {
        return ja;
    }

    public void setJa(boolean ja) {
        this.ja = ja;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
