// #3) Descubra a lógica e complete o próximo elemento.
const padraoA = [1, 3, 5, 7];
const padraoB = [2, 4, 8, 16, 32, 64];
const padraoC = [0, 1, 4, 9, 16, 25, 36];
const padraoD = [4, 16, 36, 64];
const padraoE = [1, 1, 2, 3, 5, 8];
const padraoF = [2, 10, 12, 16, 17, 18, 19];

// Ultimo valor + 2
padraoA.push(padraoA[padraoA.length - 1] + 2);
console.log(padraoA);

// Ultimo valor x 2
padraoB.push(padraoB[padraoB.length - 1] * 2);
console.log(padraoB);

// O dobro do indice
padraoC.push(padraoC.length ** 2);
console.log(padraoC);

// Próximo número par ao quadrado
padraoD.push((Math.sqrt(padraoD[padraoD.length - 1]) + 2) ** 2);
console.log(padraoD);

// Sequência de Fibonacci
padraoE.push(padraoE[padraoE.length - 2] + padraoE[padraoE.length - 1]);
console.log(padraoE);

// Iniciados com a letra 'D'
padraoF.push(200);
console.log(padraoF);
