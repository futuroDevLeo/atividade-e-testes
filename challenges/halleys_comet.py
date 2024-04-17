def will_halley_pass(year: int) -> str:
    last_pass = 1986
    period = 76
    
    years_since_last_pass = year - last_pass

    if years_since_last_pass % period == 0:
        print("HALLEY WILL PASS")
    else:
        print("HALLEY WON'T PASS")


year = int(input('Enter a year: '))
will_halley_pass(year)