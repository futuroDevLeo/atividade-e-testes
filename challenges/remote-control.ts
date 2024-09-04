// O controle remoto da TV possui botões de seta e um botão OK.
// Você pode usar esses botões para mover um cursor em um teclado na tela e digitar palavras.
// O layout do teclado na tela parece com isso:

// a  b  c  d  e  1  2  3
// f  g  h  i  j  4  5  6
// k  l  m  n  o  7  8  9
// p  q  r  s  t  .  @  0
// u  v  w  x  y  z  _  /
// aA SP -  -  -  -  -  -

// aA é a tecla SHIFT. Pressionar essa tecla alterna entre MAIÚSCULAS e minúsculas;
// SP é o caractere de espaço;
// as outras teclas em branco (-) na linha inferior não têm função.
// Crie uma função countButtonsWrap que aceite uma string words e retorne o número
// de pressionamentos de botão no controle remoto necessários para digitar as words.

// Observações:
// words é qualquer sequência de caracteres disponíveis no 'teclado' virtual;
// o cursor sempre começa na letra a (canto superior esquerdo);
// os caracteres alfabéticos estão inicialmente em minúsculas (como mostrado acima);
// lembre-se de pressionar também OK para 'aceitar' cada caractere;
// faça o percurso direto de um caractere para o próximo;
// o cursor se move em loop, ou seja, ao sair de uma borda, reaparece na borda oposta;
// embora as teclas em branco não tenham função, você pode navegar por elas se desejar;
// não pressione a tecla SHIFT até que precise. Por exemplo, com a palavra e.Z, a
// mudança para maiúscula acontece depois que . é pressionado (não antes).

// Exemplo:
// words = 'Coding Time';
// C => a-aA-OK-A-B-C-OK = 6
// o => C-B-A-aA-OK-u-v-w-x-y-t-o-OK = 12
// d => o-j-e-d-OK = 4
// i => d-i-OK = 2
// n => i-n-OK = 2
// g => n-m-l-g-OK = 4
// espaço => g-b-SP-OK = 3
// T => SP-aA-OK-U-P-Q-R-S-T-OK = 9
// i => T-S-R-Q-P-U-aA-OK-a-f-g-h-i-OK = 13
// m => i-n-m-OK = 3
// e => m-h-c-d-e-OK = 5

// countButtonsWrap(words) === 63 // 6 + 12 + 4 + 2 + 2 + 4 + 3 + 9 + 13 + 3 + 5


const countButtonsWrap = (words: String): undefined => {
    let keyboardLower = {
        'a': { x: 0, y: 0 }, 'b': { x: 1, y: 0 }, 'c': { x: 2, y: 0 }, 'd': { x: 3, y: 0 }, 'e': { x: 4, y: 0 }, '1': { x: 5, y: 0 }, '2': { x: 6, y: 0 }, '3': { x: 7, y: 0 },
        'f': { x: 0, y: 1 }, 'g': { x: 1, y: 1 }, 'h': { x: 2, y: 1 }, 'i': { x: 3, y: 1 }, 'j': { x: 4, y: 1 }, '4': { x: 5, y: 1 }, '5': { x: 6, y: 1 }, '6': { x: 7, y: 1 },
        'k': { x: 0, y: 2 }, 'l': { x: 1, y: 2 }, 'm': { x: 2, y: 2 }, 'n': { x: 3, y: 2 }, 'o': { x: 4, y: 2 }, '7': { x: 5, y: 2 }, '8': { x: 6, y: 2 }, '9': { x: 7, y: 2 },
        'p': { x: 0, y: 3 }, 'q': { x: 1, y: 3 }, 'r': { x: 2, y: 3 }, 's': { x: 3, y: 3 }, 't': { x: 4, y: 3 }, '.': { x: 5, y: 3 }, '@': { x: 6, y: 3 }, '0': { x: 7, y: 3 },
        'u': { x: 0, y: 4 }, 'v': { x: 1, y: 4 }, 'w': { x: 2, y: 4 }, 'x': { x: 3, y: 4 }, 'y': { x: 4, y: 4 }, 'z': { x: 5, y: 4 }, '_': { x: 6, y: 4 }, '/': { x: 7, y: 4 },
        'aA': { x: 0, y: 5 }, 'SP': { x: 1, y: 5 }, 'dash1': { x: 2, y: 5 }, 'dash2': { x: 3, y: 5 }, 'dash3': { x: 4, y: 5 }, 'dash4': { x: 5, y: 5 }, 'dash5': { x: 6, y: 5 }, 'dash6': { x: 7, y: 5 }
    };

    const splitedWords = words.split('');

    // Não vai funcionar pq calcula distância
    let count = 0;
    for (const word of splitedWords) {
        let char: { x: number, y: number } = keyboardLower[word];
        if (word === ' ') char = keyboardLower['SP']
        console.log(char);
        const distance = Math.sqrt(
            Math.pow(char.x - char.x, 2) +
            Math.pow(char.y - char.y, 2)
        )
        count += distance
    }
    console.log(count);

    // let x = 0;
    // let y = 0;

    // if (x < 0) {
    //     x = 7;
    // }

    // if (x > 7) {
    //     x = 0;
    // }

    // if (y < 0) {
    //     y = 5;
    // }

    // if (y > 5) {
    //     y = 0;
    // }
}

countButtonsWrap('coding time');
