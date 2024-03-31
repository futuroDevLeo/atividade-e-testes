// Let's test your knowledge on Caesar's methods

function solution(s: string): void {
    const map = /^[a-z]$/;
    const letters: string[] = s.toLowerCase().split('');
    const filteredLetters = letters.sort().filter(iten => {
        if (map.test(iten)) {
            return true;
        } else {
            return false;
        }
    });
    const singleLetters = filteredLetters.filter((este, i) => filteredLetters.indexOf(este) === i);
    let countersArray: { letter: string, counter: number }[] = [];
    for (let i = 0; i < singleLetters.length; i++) {
        const letterObject = {
            letter: singleLetters[i],
            counter: 0,
        }
        for (let j = 0; j < filteredLetters.length; j++) {
            if (singleLetters[i] === filteredLetters[j]) {
                letterObject.counter++
            }
        }
        countersArray.push(letterObject);
    }
    countersArray.sort((a: { counter: number }, b: { counter: number }) => b.counter - a.counter);

    const mostCommonLetter = countersArray[0].letter;
    const indexUnitCode = mostCommonLetter.charCodeAt(0);
    const englishMostCommonLetter = 'e'.charCodeAt(0);
    const cesarCypherShift = indexUnitCode - englishMostCommonLetter;
    const cesarCypherShiftRotate = 26 - cesarCypherShift;
    const replacedLetters: string[] = [];

    const lettersToReplace = s.toLowerCase().split('');
    for (let i = 0; i < lettersToReplace.length; i++) {
        if (map.test(lettersToReplace[i])) {
            let replacementIndex = lettersToReplace[i].charCodeAt(0) - cesarCypherShift;
            if (replacementIndex < 97) {
                replacementIndex = lettersToReplace[i].charCodeAt(0) + cesarCypherShiftRotate;
            }
            const replacement = String.fromCharCode(replacementIndex);
            replacedLetters.push(replacement);
        } else {
            replacedLetters.push(lettersToReplace[i])
        }
    }
    const sReplaced = replacedLetters.join('');

    return console.log(sReplaced);
}

solution('Naljnl, Pnrfne jnf n fxvyyrq pbzzhavpngbe, naq ur hfrq n inevrgl bs zrgubqf gb xrrc uvf zrffntrf frperg sebz uvf rarzvrf. Bar bs gurfr zrgubqf jnf gur Pnrfne pvcure, n fvzcyr grpuavdhr gb boshfpngr pbzzhavpngvbaf. SYNT{ebgngr_gung_nycunorg}');
