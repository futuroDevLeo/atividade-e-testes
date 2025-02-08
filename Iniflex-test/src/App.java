import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    static {
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios
                .add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios
                .add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.23"), "Gerente"));
    }

    public static void main(String[] args) throws Exception {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao();

        aplicarAumento(0.10);
        System.out.println("Funcionários após aumento de 10%:\n");
        printFuncionarios();
        System.out.println("--------------------------------------------------\n");
        System.out.println("Funcionários agrupados por função:\n");
        printFuncionariosPorFuncao(funcionariosPorFuncao);
        System.out.println("--------------------------------------------------\n");
        System.out.println("Aniversariantes de outubro e dezembro:\n");
        printAniversariantes(10, 12);
        System.out.println("--------------------------------------------------\n");
        printFuncionarioMaisVelho();
        System.out.println("--------------------------------------------------\n");
        System.out.println("Funcionários em ordem alfabética:\n");
        printFuncionariosOrdemAlfabetica();
        System.out.println("--------------------------------------------------\n");
        System.out.println("Total dos salários:\n");
        printTotalSalarios();
        System.out.println("--------------------------------------------------\n");
        System.out.println("Salários em salários mínimos:\n");
        printSalariosMinimos();
    }

    public static void aplicarAumento(double percentual) {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(BigDecimal.valueOf(percentual));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        }
    }

    public static void printFuncionarios() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale localeBR = new Locale("pt", "BR");

        for (Funcionario funcionario : funcionarios) {
            String dataFormatada = funcionario.getDataNascimento().format(dateFormatter);
            String salarioFormatado = String.format(localeBR, "%,.2f", funcionario.getSalario());

            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + dataFormatada);
            System.out.println("Salário: " + salarioFormatado);
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println();
        }
    }

    public static Map<String, List<Funcionario>> agruparPorFuncao() {
        Map<String, List<Funcionario>> map = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            map.computeIfAbsent(funcionario.getFuncao(), k -> new ArrayList<>()).add(funcionario);
        }
        return map;
    }

    public static void printFuncionariosPorFuncao(Map<String, List<Funcionario>> map) {
        for (Map.Entry<String, List<Funcionario>> entry : map.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println("  Nome: " + funcionario.getNome());
                System.out.println("  Data de Nascimento: "
                        + funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println(
                        "  Salário: " + String.format(new Locale("pt", "BR"), "%,.2f", funcionario.getSalario()));
                System.out.println();
            }
        }
    }

    public static void printAniversariantes(int... meses) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale localeBR = new Locale("pt", "BR");

        for (Funcionario funcionario : funcionarios) {
            int mesNascimento = funcionario.getDataNascimento().getMonthValue();
            for (int mes : meses) {
                if (mesNascimento == mes) {
                    String dataFormatada = funcionario.getDataNascimento().format(dateFormatter);
                    String salarioFormatado = String.format(localeBR, "%,.2f", funcionario.getSalario());

                    System.out.println("Nome: " + funcionario.getNome());
                    System.out.println("Data de Nascimento: " + dataFormatada);
                    System.out.println("Salário: " + salarioFormatado);
                    System.out.println("Função: " + funcionario.getFuncao());
                    System.out.println();
                }
            }
        }
    }

    public static void printFuncionarioMaisVelho() {
        Funcionario maisVelho = null;
        int maiorIdade = 0;

        for (Funcionario funcionario : funcionarios) {
            int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
            if (idade > maiorIdade) {
                maiorIdade = idade;
                maisVelho = funcionario;
            }
        }

        if (maisVelho != null) {
            System.out.println("Funcionário com a maior idade:\n");
            System.out.println("Nome: " + maisVelho.getNome());
            System.out.println("Idade: " + maiorIdade + " anos");
            System.out.println();
        }
    }

    public static void printFuncionariosOrdemAlfabetica() {
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
        printFuncionarios();
        System.out.println();
    }

    public static void printTotalSalarios() {
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        String totalSalariosFormatado = String.format(new Locale("pt", "BR"), "%,.2f", totalSalarios);
        System.out.println("Total dos salários: " + totalSalariosFormatado);
        System.out.println();
    }

    public static void printSalariosMinimos() {
        double salarioMinimo = 1212.00;
        for (Funcionario funcionario : funcionarios) {
            double salariosMinimos = funcionario.getSalario().doubleValue() / salarioMinimo;
            System.out.println("Nome: " + funcionario.getNome());
            System.out.printf("Salários Mínimos: %.2f", salariosMinimos);
            System.out.println();
        }
    }
}
