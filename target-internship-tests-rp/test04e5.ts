/*
4) Descubra a lógica e complete o próximo elemento:
a) 1, 3, 5, 7, 9
b) 2, 4, 8, 16, 32, 64, 128
c) 0, 1, 4, 9, 16, 25, 36, 49
d) 4, 16, 36, 64, 100
e) 1, 1, 2, 3, 5, 8, 13
f) 2, 10, 12, 16, 17, 18, 19, 200

REPOSTA:
a) O ultimo elemento + 2;
b) O dobro do elemento anterior;
C) O quadrados de cada número de 0 a 7 (7²);
D) O quadrados dos números pares;
E) A sequência de Fibonacci;
F) O próximo número começando com "D".
*/


/*
5) Você está em uma sala com três interruptores, cada um conectado a uma lâmpada em salas diferentes.
Você não pode ver as lâmpadas da sala em que está, mas pode ligar e desligar os interruptores quantas
vezes quiser. Seu objetivo é descobrir qual interruptor controla qual lâmpada. Como você faria para
descobrir, usando apenas duas idas até uma das salas das lâmpadas, qual interruptor controla cada lâmpada?

RESPOSTA:
Ligo o primeiro interruptor e deixo ele ligado um tempo considerável, depois desligo o primeiro interruptor
e ligo o segundo. Dessa forma vou até a primeira sala das lâmpadas: Se ela estiver quente, é do primeiro interruptor,
se ela estiver acesa, é do segundo interruptor, se ela estiver apagada e fria, é do terceiro interruptor.
Assim irei até a segunda sala e faço a mesma verificação. Quente = primeira, Acesa = segundo, Apagada = terceira.
Logo a que eu não puder ver, será a opção que sobrou.
*/