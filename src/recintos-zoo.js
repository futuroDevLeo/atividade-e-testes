class RecintosZoo {

    constructor() {
        this.recintos = [
            { numero: 1, bioma: 'savana', tamanho: 10, animais: ['MACACO', 'MACACO', 'MACACO'] },
            { numero: 2, bioma: 'floresta', tamanho: 5, animais: [] },
            { numero: 3, bioma: 'savana e rio', tamanho: 7, animais: ['GAZELA'] },
            { numero: 4, bioma: 'rio', tamanho: 8, animais: [] },
            { numero: 5, bioma: 'savana', tamanho: 9, animais: ['LEAO'] }
        ];

        this.animaisPermitidos = {
            'LEAO': { tamanho: 3, bioma: ['savana'], carnivoro: true },
            'LEOPARDO': { tamanho: 2, bioma: ['savana'], carnivoro: true },
            'CROCODILO': { tamanho: 3, bioma: ['rio'], carnivoro: true },
            'MACACO': { tamanho: 1, bioma: ['savana', 'floresta'], carnivoro: false },
            'GAZELA': { tamanho: 2, bioma: ['savana'], carnivoro: false },
            'HIPOPOTAMO': { tamanho: 4, bioma: ['savana', 'rio'], carnivoro: false }
        };
    }

    analisaRecintos(animal, quantidade) {
        animal = animal.toUpperCase();

        if (!this.animaisPermitidos[animal]) {
            return { erro: 'Animal inválido' };
        }

        if (quantidade <= 0 || isNaN(quantidade)) {
            return { erro: 'Quantidade inválida' };
        }

        const biomasPermitidos = this.animaisPermitidos[animal].bioma;
        const tamanhoNecessario = quantidade * this.animaisPermitidos[animal].tamanho;
        const recintosViaveis = [];

        for (const recinto of this.recintos) {
            const tamanhoRecinto = recinto.tamanho;
            const animaisNoRecinto = recinto.animais;
            const biomas = recinto.bioma.split(' e ');

            if (biomas.some(bioma => biomasPermitidos.includes(bioma))) {
                let espacoUsado = 0;

                for (const animalNoRecinto of animaisNoRecinto) {
                    espacoUsado += this.animaisPermitidos[animalNoRecinto].tamanho;
                }

                if (animaisNoRecinto.length > 0 && !animaisNoRecinto.includes(animal)) {
                    espacoUsado += 1;
                }

                if (quantidade === 1 && animal === 'MACACO') {
                    if (animaisNoRecinto.some((animailNoRecinto) => animailNoRecinto === 'MACACO')) {
                        recintosViaveis.push(
                            `Recinto ${recinto.numero} (espaço livre: ${tamanhoRecinto - espacoUsado - tamanhoNecessario} total: ${tamanhoRecinto})`
                        )
                    }

                    return { recintosViaveis: recintosViaveis };
                }

                if ((tamanhoRecinto - espacoUsado) >= tamanhoNecessario &&
                    (animaisNoRecinto.length === 0 ||
                        animaisNoRecinto.every(animalNoRecinto =>
                            this.animaisPermitidos[animalNoRecinto].carnivoro === this.animaisPermitidos[animal].carnivoro))) {
                    recintosViaveis.push(
                        `Recinto ${recinto.numero} (espaço livre: ${tamanhoRecinto - espacoUsado - tamanhoNecessario} total: ${tamanhoRecinto})`
                    );
                }
            }
        }

        if (recintosViaveis.length === 0) {
            return { erro: "Não há recinto viável" };
        }

        return { recintosViaveis: recintosViaveis };
    }
}

export { RecintosZoo as RecintosZoo };
