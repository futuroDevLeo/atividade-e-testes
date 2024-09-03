// 1) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
// (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número,
// ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

import * as rl from "readline-sync";

const isFibonacciRange = (n: number): string => {
    if (n === 0 || n === 1) {
        return `O número ${n} FAZ parte da sequência Fibonacci`;
    }

    if (n < 0) {
        return `O número ${n} NÃO FAZ parte da sequência Fibonacci`;
    }

    let lastButOneTerm = 0;
    let lastTerm = 1;

    while (lastTerm < n) {
        let newTerm = lastButOneTerm + lastTerm;
        lastButOneTerm = lastTerm;
        lastTerm = newTerm;
    }

    if (lastTerm === n) {
        return `O número ${n} FAZ parte da sequência Fibonacci`;
    } else {
        return `O número ${n} NÃO FAZ parte da sequência Fibonacci`;
    }
}

const numberProvided = rl.questionInt('Digite um numero: ');
console.log(isFibonacciRange(numberProvided));