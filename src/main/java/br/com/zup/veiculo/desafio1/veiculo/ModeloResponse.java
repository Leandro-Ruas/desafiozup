package br.com.zup.veiculo.desafio1.veiculo;

public class ModeloResponse {

    private String nome;
    private String codigo;

    @Deprecated
    public ModeloResponse() {
    }

    public ModeloResponse(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "ModeloResponse{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
