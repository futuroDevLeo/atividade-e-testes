# 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa,
# na linguagem que desejar, que calcule e retorne:
# • O menor valor de faturamento ocorrido em um dia do mês;
# • O maior valor de faturamento ocorrido em um dia do mês;
# • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

# IMPORTANTE:
# a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
# b) Podem existir dias sem faturamento, como nos finais de semana e feriados.
# Estes dias devem ser ignorados no cálculo da média;

import json

file = 'dados.json'

try:
    with open(file, 'rt') as file:
        data_JSON = file.read()
    data = json.loads(data_JSON)
except FileExistsError:
    print(f"O arquivo '{file}' não foi encontrado.")
except json.JSONDecodeError:
    print("Erro ao decodificar o JSON.")

revenues = []
days_above_average = 0
min_revenue = float('inf')
max_revenue = float('-inf')

for item in data:
    values = list(item.values())
    day = values[0]
    revenue = values[1]

    if revenue > 0.0:
        if revenue > max_revenue:
            max_revenue = revenue

        if revenue < min_revenue:
            min_revenue = revenue
        
        revenues.append(revenue)

average_revenue = sum(revenues) / len(revenues)
for value in revenues:
    if value > average_revenue:
        days_above_average += 1

print("Maior faturamento:", max_revenue)
print("Menor faturamento:", min_revenue)
print('Quantidade de dias com faturamento acima da média:', days_above_average)