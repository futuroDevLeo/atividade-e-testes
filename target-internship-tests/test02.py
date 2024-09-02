# 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
# (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número,
# ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

# IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;

def isFibonacciRange(n: int):
    if (n == 0 or n == 1):
        print(f"O número {n} faz parte da sequência Fibonacci")
        return
    
    if n < 0:
        print(f"O número {n} não faz parte da sequência Fibonacci")
        return

    fibonacci = [0, 1]

    while fibonacci[-1] < n:
        fibonacci.append(fibonacci[-1] + fibonacci[-2])

    if n in fibonacci:
        print(f"O número {n} faz parte da sequência Fibonacci")
    else:
        print(f"O número {n} não faz parte da sequência Fibonacci")


number_provide = int(input('Digite um número: '))
isFibonacciRange(number_provide)
