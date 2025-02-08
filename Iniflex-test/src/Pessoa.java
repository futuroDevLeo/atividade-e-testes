import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate data_nascimento;

    public Pessoa(String nome, LocalDate data_nascimento) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return data_nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
