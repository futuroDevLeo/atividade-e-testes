# 5) Escreva um programa que inverta os caracteres de um string.

# IMPORTANTE:
# a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
# b) Evite usar funções prontas, como, por exemplo, reverse;

def invert_word(w: str):
    new_w = ''
    for letter in w:
        new_w = letter + new_w
    print(new_w)

word = input('Digite uma palavra: ')
invert_word(word)