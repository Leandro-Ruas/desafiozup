package br.com.zup.veiculo.desafio1.veiculo;

public class MarcaFeignResponse {

    private String nome;

    private String codigo;

    @Deprecated
    public MarcaFeignResponse() {
    }

    public MarcaFeignResponse(String nome, String codigo) {
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
        return "MarcaFeignResponse{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
