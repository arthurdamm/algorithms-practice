// LeetCode 1286. Iterator for Combination
// O(nCr) time-and-space
class CombinationIterator {
    combinations = [];
    combinationIndex = 0;
    constructor(characters: string, combinationLength: number) {
        const backtrack = (s, i) => {
            if (s.length === combinationLength) {
                this.combinations.push(s.join(''));
                return;
            }
            for (let j = i; j < characters.length; j++) {
                s.push(characters[j]);
                backtrack(s, j + 1);
                s.pop();
            }
        };
        backtrack([], 0);
    }

    next(): string {
        return this.combinations[this.combinationIndex++];
    }

    hasNext(): boolean {
        return this.combinationIndex < this.combinations.length;
    }
}
