// Leia dois valores inteiros. A seguir, calcule o produto entre estes dois valores e atribua esta operação
// à variável PROD. A seguir mostre a variável PROD com mensagem correspondente.

// Entrada
// O arquivo de entrada contém 2 valores inteiros.

// Saída
// Imprima a mensagem "PROD" e a variável PROD conforme exemplo abaixo, com um espaço em branco antes e depois
// da igualdade. Não esqueça de imprimir o fim de linha após o produto, caso contrário seu programa apresentará
// a mensagem: “Presentation Error”.

#include <stdio.h>

int calculatePROD(int n1, int n2)
{
    int result = n1 * n2;
    return result;
}

int main()
{
    int n1 = 0;
    int n2 = 0;
    while ((scanf("%d", &n1) != EOF) && (scanf("%d", &n2) != EOF))
    {
        int PROD = calculatePROD(n1, n2);
        printf("PROD = %d\n", PROD);
    }
    return 0;
}