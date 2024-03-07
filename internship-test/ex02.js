// #2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
//  (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número,
//   ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
const fibonacci = (numero) => {
    if (numero === 0 || numero === 1) {
        return true;
    }

    const sequenciaFibonacci = [0, 1];
    let penultimoElemento = sequenciaFibonacci[0];
    let ultimoElemento = sequenciaFibonacci[1];

    while (sequenciaFibonacci[sequenciaFibonacci.length - 1] < numero) {
        sequenciaFibonacci.push(sequenciaFibonacci[penultimoElemento] + sequenciaFibonacci[ultimoElemento]);
        penultimoElemento = sequenciaFibonacci.length - 2;
        ultimoElemento = sequenciaFibonacci.length - 1;
    }

    if (sequenciaFibonacci[sequenciaFibonacci.length - 1] === numero) {
        return true;
    } else {
        return false;
    }
}

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Digite um número: ', (numeroInformado) => {
    const numeroFibonacci = fibonacci(Number(numeroInformado));
    if (numeroFibonacci === false) {
        console.log(`O número ${numeroInformado} não faz parte da sequência Fibonacci`);
    } else {
        console.log(`O número ${numeroInformado} faz parte da sequência Fibonacci`);
    }
    rl.close();
});
