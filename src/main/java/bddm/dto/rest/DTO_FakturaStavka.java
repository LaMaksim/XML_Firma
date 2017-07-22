package bddm.dto.rest;

/**
 * Created by maksim on 22-Jul-17.
 */
public class DTO_FakturaStavka {

    protected int rbr;
    protected String naziv;
    protected float kolicina;
    protected String jedinicaMere;
    protected float jedinicnaCena;
    protected float vrednost;
    protected float procenatRabata;
    protected float iznosRabata;
    protected float umanjenoZaRabat;

    public DTO_FakturaStavka() {
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public float getKolicina() {
        return kolicina;
    }

    public void setKolicina(float kolicina) {
        this.kolicina = kolicina;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(String jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public float getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(float jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    public float getVrednost() {
        return vrednost;
    }

    public void setVrednost(float vrednost) {
        this.vrednost = vrednost;
    }

    public float getProcenatRabata() {
        return procenatRabata;
    }

    public void setProcenatRabata(float procenatRabata) {
        this.procenatRabata = procenatRabata;
    }

    public float getIznosRabata() {
        return iznosRabata;
    }

    public void setIznosRabata(float iznosRabata) {
        this.iznosRabata = iznosRabata;
    }

    public float getUmanjenoZaRabat() {
        return umanjenoZaRabat;
    }

    public void setUmanjenoZaRabat(float umanjenoZaRabat) {
        this.umanjenoZaRabat = umanjenoZaRabat;
    }


}
