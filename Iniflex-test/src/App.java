import java.util.Collections;
import java.util.Comparator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
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
        System.out.println("Todos os Funcionarios:\n");
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
            funcionario.aumentarSalario(percentual);
        }
    }

    public static void printFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.imprimir(true, true, true, true);
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
            System.out.println("-- Função: " + entry.getKey() + " --");
            for (Funcionario funcionario : entry.getValue()) {
                funcionario.imprimir(true, true, true, false);
            }
        }
    }

    public static void printAniversariantes(int... meses) {
        for (Funcionario funcionario : funcionarios) {
            int mesNascimento = funcionario.getDataNascimento().getMonthValue();
            for (int mes : meses) {
                if (mesNascimento == mes) {
                    funcionario.imprimir(true, true, true, true);
                }
            }
        }
    }

    public static void printFuncionarioMaisVelho() {
        Funcionario maisVelho = null;
        int maiorIdade = 0;

        for (Funcionario funcionario : funcionarios) {
            int idade = funcionario.getIdade();

            if (idade > maiorIdade) {
                maiorIdade = idade;
                maisVelho = funcionario;
            }
        }

        if (maisVelho != null) {
            System.out.println("Funcionário com a maior idade:\n");
            System.out.println("Nome: " + maisVelho.getNome());
            System.out.println("Idade: " + maiorIdade + " anos\n");
        }
    }

    public static void printFuncionariosOrdemAlfabetica() {
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
        printFuncionarios();
    }

    public static void printTotalSalarios() {
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        String totalSalariosFormatado = String.format(new Locale("pt", "BR"), "%,.2f", totalSalarios);
        System.out.println(totalSalariosFormatado + "\n");
    }

    public static void printSalariosMinimos() {
        double salarioMinimo = 1212.00;
        for (Funcionario funcionario : funcionarios) {
            double salariosMinimos = funcionario.getSalario().doubleValue() / salarioMinimo;
            System.out.println("Nome: " + funcionario.getNome());
            System.out.printf("Salários Mínimos: %.2f\n", salariosMinimos);
            System.out.println();
        }
    }
}
