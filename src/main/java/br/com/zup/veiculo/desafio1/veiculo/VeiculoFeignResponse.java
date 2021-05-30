package br.com.zup.veiculo.desafio1.veiculo;

import br.com.zup.veiculo.desafio1.usuario.Usuario;

import java.util.Optional;

public class VeiculoFeignResponse {

    private String Valor;
    private String Marca;
    private String Modelo;
    private int AnoModelo;
    private String Combustivel;
    private String CodigoFipe;
    private String MesReferencia;
    private String TipoVeiculo;
    private String SiglaCombustivel;

    @Deprecated
    public VeiculoFeignResponse() {
    }

    public VeiculoFeignResponse(String valor, String marca, String modelo, int anoModelo, String combustivel, String codigoFipe, String mesReferencia, String tipoVeiculo, String siglaCombustivel) {
        Valor = valor;
        Marca = marca;
        Modelo = modelo;
        AnoModelo = anoModelo;
        Combustivel = combustivel;
        CodigoFipe = codigoFipe;
        MesReferencia = mesReferencia;
        TipoVeiculo = tipoVeiculo;
        SiglaCombustivel = siglaCombustivel;
    }

    public String getValor() {
        return Valor;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getAnoModelo() {
        return AnoModelo;
    }

    public String getCombustivel() {
        return Combustivel;
    }

    public String getCodigoFipe() {
        return CodigoFipe;
    }

    public String getMesReferencia() {
        return MesReferencia;
    }

    public String getTipoVeiculo() {
        return TipoVeiculo;
    }

    public String getSiglaCombustivel() {
        return SiglaCombustivel;
    }

    @Override
    public String toString() {
        return "VeiculoFeignResponse{" +
                "Valor='" + Valor + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", AnoModelo=" + AnoModelo +
                ", Combustivel='" + Combustivel + '\'' +
                ", CodigoFipe='" + CodigoFipe + '\'' +
                ", MesReferencia='" + MesReferencia + '\'' +
                ", TipoVeiculo='" + TipoVeiculo + '\'' +
                ", SiglaCombustivel='" + SiglaCombustivel + '\'' +
                '}';
    }


    public Veiculo toModel(Usuario usuario) {
        return new Veiculo(Valor,
                Marca,
                Modelo,
                AnoModelo,
                Combustivel,
                CodigoFipe,
                MesReferencia,
                TipoVeiculo,
                SiglaCombustivel,
                usuario);
    }
}
