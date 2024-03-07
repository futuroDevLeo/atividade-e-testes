// #5) Escreva um programa que inverta os caracteres de um string.
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Digite uma palavra: ', (palavraDigitada) => {
    const letrasPalavra = palavraDigitada.trim().split('');
    const arrayNovaPalavra = [];
    for (const letra of letrasPalavra) {
        arrayNovaPalavra.unshift(letra);
    }
    const novaPalavra = arrayNovaPalavra.join('');
    console.log(novaPalavra);
    rl.close();
});