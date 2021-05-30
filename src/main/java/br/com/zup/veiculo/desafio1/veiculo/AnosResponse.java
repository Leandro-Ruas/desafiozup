package br.com.zup.veiculo.desafio1.veiculo;

public class AnosResponse {

    private String nome;
    private String codigo;

    @Deprecated
    public AnosResponse() {
    }

    public AnosResponse(String nome, String codigo) {
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
        return "AnosResponse{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
