package br.com.zup.veiculo.desafio1.veiculo;

import br.com.zup.veiculo.desafio1.usuario.Usuario;

import javax.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valor;
    private String marca;
    private String modelo;
    private Integer anoModelo;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private String tipoVeiculo;
    private String siglaCombustivel;

    private String rodizio;

    private boolean statusRodizio;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Usuario usuario;

    @Deprecated
    public Veiculo() {
    }

    public Veiculo(String valor, String marca, String modelo, int anoModelo, String combustivel, String codigoFipe, String mesReferencia, String tipoVeiculo, String siglaCombustivel, Usuario usuario) {
        this.anoModelo = anoModelo;
        this.codigoFipe = codigoFipe;
        this.usuario = usuario;
        this.combustivel = combustivel;
        this.marca = marca;
        this.mesReferencia = mesReferencia;
        this.valor = valor;
        this.modelo = modelo;
        this.siglaCombustivel = siglaCombustivel;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Long getId() {
        return id;
    }

    public String getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getRodizio() {
        return rodizio;
    }

    public boolean isStatusRodizio() {
        return statusRodizio;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", tipoVeiculo='" + tipoVeiculo + '\'' +
                ", siglaCombustivel='" + siglaCombustivel + '\'' +
                ", usuario=" + usuario +
                '}';
    }

    public void addRodizio(String rodizio) {
        this.rodizio = rodizio;
    }

    public void adicionaStatus(boolean status) {
        this.statusRodizio = status;
    }
}
