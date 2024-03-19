const fibonacciSequencer = (params) => {
    const terms = params;
    const fibonacci = [];

    while (fibonacci.length < terms) {
        if (fibonacci.length === 0) {
            fibonacci.push(0);
            fibonacci.push(1);
        }

        const lastTerm = fibonacci[fibonacci.length - 1];
        const previousTerm = fibonacci[fibonacci.length - 2];
        const sum = lastTerm + previousTerm;

        fibonacci.push(sum);
    }

    return fibonacci;
}

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Digite um número: ', (numberInformed) => {
    const fibonacciTerms = fibonacciSequencer(Number(numberInformed));
    console.log(fibonacciTerms);
    rl.close();
});