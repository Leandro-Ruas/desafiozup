package br.com.zup.veiculo.desafio1.veiculo;

public class UsuarioListaVeiculoResponse {

    private String valor;
    private String marca;
    private String modelo;
    private int anoModelo;
    private String codigoFipe;
    private String tipoVeiculo;

    @Deprecated
    public UsuarioListaVeiculoResponse() {
    }

    public UsuarioListaVeiculoResponse(Veiculo veiculo) {
        this.valor = veiculo.getValor();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();;
        this.anoModelo = veiculo.getAnoModelo();;
        this.codigoFipe = veiculo.getCodigoFipe();;
        this.tipoVeiculo = veiculo.getTipoVeiculo();
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

    public int getAnoModelo() {
        return anoModelo;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }
}
