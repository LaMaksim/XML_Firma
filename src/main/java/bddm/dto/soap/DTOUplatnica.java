//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.22 at 06:41:53 PM CEST 
//


package bddm.dto.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DTO_Uplatnica complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DTO_Uplatnica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duznikNaziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="svrhaPlacanja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="primalacNaziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datumUplate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datumValute" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="duznikRacun" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelZaduzenja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pozivNaBrojZaduzenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="racunPoverioca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelOdobrenja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pozivNaBrojOdobrenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iznos" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="oznakaValute" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hitnost" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTO_Uplatnica", propOrder = {
    "id",
    "duznikNaziv",
    "svrhaPlacanja",
    "primalacNaziv",
    "datumUplate",
    "datumValute",
    "duznikRacun",
    "modelZaduzenja",
    "pozivNaBrojZaduzenja",
    "racunPoverioca",
    "modelOdobrenja",
    "pozivNaBrojOdobrenja",
    "iznos",
    "oznakaValute",
    "hitnost"
})
public class DTOUplatnica {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String duznikNaziv;
    @XmlElement(required = true)
    protected String svrhaPlacanja;
    @XmlElement(required = true)
    protected String primalacNaziv;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumUplate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumValute;
    @XmlElement(required = true)
    protected String duznikRacun;
    protected int modelZaduzenja;
    @XmlElement(required = true)
    protected String pozivNaBrojZaduzenja;
    @XmlElement(required = true)
    protected String racunPoverioca;
    protected int modelOdobrenja;
    @XmlElement(required = true)
    protected String pozivNaBrojOdobrenja;
    protected float iznos;
    @XmlElement(required = true)
    protected String oznakaValute;
    protected boolean hitnost;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the duznikNaziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuznikNaziv() {
        return duznikNaziv;
    }

    /**
     * Sets the value of the duznikNaziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuznikNaziv(String value) {
        this.duznikNaziv = value;
    }

    /**
     * Gets the value of the svrhaPlacanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    /**
     * Sets the value of the svrhaPlacanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrhaPlacanja(String value) {
        this.svrhaPlacanja = value;
    }

    /**
     * Gets the value of the primalacNaziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimalacNaziv() {
        return primalacNaziv;
    }

    /**
     * Sets the value of the primalacNaziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimalacNaziv(String value) {
        this.primalacNaziv = value;
    }

    /**
     * Gets the value of the datumUplate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumUplate() {
        return datumUplate;
    }

    /**
     * Sets the value of the datumUplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumUplate(XMLGregorianCalendar value) {
        this.datumUplate = value;
    }

    /**
     * Gets the value of the datumValute property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumValute() {
        return datumValute;
    }

    /**
     * Sets the value of the datumValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumValute(XMLGregorianCalendar value) {
        this.datumValute = value;
    }

    /**
     * Gets the value of the duznikRacun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuznikRacun() {
        return duznikRacun;
    }

    /**
     * Sets the value of the duznikRacun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuznikRacun(String value) {
        this.duznikRacun = value;
    }

    /**
     * Gets the value of the modelZaduzenja property.
     * 
     */
    public int getModelZaduzenja() {
        return modelZaduzenja;
    }

    /**
     * Sets the value of the modelZaduzenja property.
     * 
     */
    public void setModelZaduzenja(int value) {
        this.modelZaduzenja = value;
    }

    /**
     * Gets the value of the pozivNaBrojZaduzenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBrojZaduzenja() {
        return pozivNaBrojZaduzenja;
    }

    /**
     * Sets the value of the pozivNaBrojZaduzenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBrojZaduzenja(String value) {
        this.pozivNaBrojZaduzenja = value;
    }

    /**
     * Gets the value of the racunPoverioca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacunPoverioca() {
        return racunPoverioca;
    }

    /**
     * Sets the value of the racunPoverioca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacunPoverioca(String value) {
        this.racunPoverioca = value;
    }

    /**
     * Gets the value of the modelOdobrenja property.
     * 
     */
    public int getModelOdobrenja() {
        return modelOdobrenja;
    }

    /**
     * Sets the value of the modelOdobrenja property.
     * 
     */
    public void setModelOdobrenja(int value) {
        this.modelOdobrenja = value;
    }

    /**
     * Gets the value of the pozivNaBrojOdobrenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBrojOdobrenja() {
        return pozivNaBrojOdobrenja;
    }

    /**
     * Sets the value of the pozivNaBrojOdobrenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBrojOdobrenja(String value) {
        this.pozivNaBrojOdobrenja = value;
    }

    /**
     * Gets the value of the iznos property.
     * 
     */
    public float getIznos() {
        return iznos;
    }

    /**
     * Sets the value of the iznos property.
     * 
     */
    public void setIznos(float value) {
        this.iznos = value;
    }

    /**
     * Gets the value of the oznakaValute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOznakaValute() {
        return oznakaValute;
    }

    /**
     * Sets the value of the oznakaValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOznakaValute(String value) {
        this.oznakaValute = value;
    }

    /**
     * Gets the value of the hitnost property.
     * 
     */
    public boolean isHitnost() {
        return hitnost;
    }

    /**
     * Sets the value of the hitnost property.
     * 
     */
    public void setHitnost(boolean value) {
        this.hitnost = value;
    }

}
