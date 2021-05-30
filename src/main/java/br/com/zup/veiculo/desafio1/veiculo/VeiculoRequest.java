package br.com.zup.veiculo.desafio1.veiculo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VeiculoRequest {

    @NotBlank
    @NotNull
    private String tipo;

    @NotBlank
    @NotNull
    private String numeroMarca;

    @NotBlank
    @NotNull
    private String numeroModel;

    @NotBlank
    @NotNull
    private String ano;

    @NotNull
    private Long idUsuario;

    @Deprecated
    public VeiculoRequest() {
    }

    public VeiculoRequest(String tipo, String numeroMarca, String numeroModel, String ano, Long idUsuario) {
        this.tipo = tipo;
        this.numeroMarca = numeroMarca;
        this.numeroModel = numeroModel;
        this.ano = ano;
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumeroMarca() {
        return numeroMarca;
    }

    public String getNumeroModel() {
        return numeroModel;
    }

    public String getAno() {
        return ano;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "VeiculoRequest{" +
                "tipo='" + tipo + '\'' +
                ", numeroMarca='" + numeroMarca + '\'' +
                ", numeroModel='" + numeroModel + '\'' +
                ", ano='" + ano + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
