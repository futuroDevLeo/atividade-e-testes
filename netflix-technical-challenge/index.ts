const solution = (s: string): string => {
    const newS: string[] = s.trim().split("");

    for (let i = 0; i < newS.length; i++) {
        let counter: number = 0;
        for (let j = 0; j < newS.length; j++) {
            if (newS[i] === newS[j] && i !== j) {
                counter++
            }
        }

        if (counter === 0) {
            return newS[i];
        }
    }

    return "_";
}

console.log(solution("abacabad"));
console.log(solution("abacabaabacaba"));
console.log(solution("abcdefghijlmnopqrstuvxzzxvutsrqponmkljihgfedcba"));