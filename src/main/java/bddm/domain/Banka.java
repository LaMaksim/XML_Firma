package bddm.domain;

import javax.persistence.*;

@Entity
public class Banka {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BNK")
    @SequenceGenerator(name = "SEQ_BNK", sequenceName = "SEQ_BANKA", allocationSize = 1)
    @Column(name = "BNK_ID")
    private Long id;

    @Column(name = "BNK_PORT", nullable = false)
    private int bankaPort;

    @Column(name = "BNK_NAZIV", nullable = false)
    private String bankaNaziv;

    public Banka() {}

    public Banka(int bankaPort, String bankaNaziv) {
        this.bankaPort = bankaPort;
        this.bankaNaziv = bankaNaziv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBankaPort() {
        return bankaPort;
    }

    public void setBankaPort(int bankaPort) {
        this.bankaPort = bankaPort;
    }

    public String getBankaNaziv() {
        return bankaNaziv;
    }

    public void setBankaNaziv(String bankaNaziv) {
        this.bankaNaziv = bankaNaziv;
    }
}
