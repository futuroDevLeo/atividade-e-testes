import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - data_nascimento.getYear();

        if (dataAtual.getMonthValue() < data_nascimento.getMonthValue() ||
                (dataAtual.getMonthValue() == data_nascimento.getMonthValue()
                        && dataAtual.getDayOfMonth() < data_nascimento.getDayOfMonth())) {
            idade--;
        }

        return idade;
    }

    public String getDataFormatada() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = this.getDataNascimento().format(dateFormatter);
        return dataFormatada;
    }
}
