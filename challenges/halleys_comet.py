def will_halley_pass(ano):
    last_pass = 1986
    period = 76
    
    years_since_last_pass = ano - last_pass

    if years_since_last_pass % period == 0:
        print("HALLEY WILL PASS")
    else:
        print("HALLEY WON'T PASS")


ano = int(input('Enter a year: '))
will_halley_pass(ano)