# LeetCode #299. Bulls and Cows
class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        secrets = defaultdict(int)
        guesses = defaultdict(int)
        A = 0
        B = 0
        for i in range(len(guess)):
            if guess[i] == secret[i]:
                A += 1
            else:
                secrets[secret[i]] += 1
                guesses[guess[i]] += 1
        for g in guesses:
            B += min(guesses[g], secrets[g])
        return "{}A{}B".format(A, B)
