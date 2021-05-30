package br.com.zup.veiculo.desafio1.usuario;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioRequest {


    @NotNull
    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @Email
    private String email;

    @NotNull
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "UsuarioRequest{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    @Deprecated
    public UsuarioRequest() {
    }

    public UsuarioRequest(String nome, String cpf, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Usuario toModel() {
        return new Usuario(nome, email, dataNascimento, cpf);
    }
}
