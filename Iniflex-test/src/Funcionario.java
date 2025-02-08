import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao) {
        super(nome, data_nascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void aumentarSalario(double percentual) {
        BigDecimal aumento = salario.multiply(BigDecimal.valueOf(percentual));
        salario = salario.add(aumento);
    }

    public String getSalarioFormatado() {
        Locale localeBR = new Locale("pt", "BR");
        return String.format(localeBR, "%,.2f", this.getSalario());
    }

    public void imprimir(boolean nome, boolean data, boolean salario, boolean funcao) {
        if (nome) {
            System.out.println("Nome: " + this.getNome());
        }
        if (data) {
            System.out.println("Data de Nascimento: " + this.getDataFormatada());
        }
        if (salario) {
            System.out.println("Salário: " + this.getSalarioFormatado());
        }
        if (funcao) {
            System.out.println("Função: " + this.getFuncao());
        }
        System.out.println();
    }
}
