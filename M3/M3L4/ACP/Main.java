class WordMatch {
    private String secret;
    public WordMatch(String word) { secret = word; }

    // (a)
    public int scoreGuess(String guess) {
        int count = 0;
        for (int i = 0; i <= secret.length() - guess.length(); i++) {
            if (secret.substring(i, i + guess.length()).equals(guess)) {
                count++;
            }
        }
        return count * guess.length() * guess.length();
    }

    // (b)
    public String findBetterGuess(String guess1, String guess2) {
        int s1 = scoreGuess(guess1);
        int s2 = scoreGuess(guess2);
        if (s1 > s2) return guess1;
        if (s2 > s1) return guess2;
        // tie
        return (guess1.compareTo(guess2) > 0) ? guess1 : guess2;
    }
}

public class Main {
    public static void main(String[] args) {
        WordMatch game = new WordMatch("concatenation");
        
        System.out.println(game.scoreGuess("ten")); // 9
        System.out.println(game.scoreGuess("nation")); // 36
        System.out.println(game.findBetterGuess("ten", "nation")); // nation

        System.out.println(game.scoreGuess("con")); // 9
        System.out.println(game.scoreGuess("cat")); // 9
        System.out.println(game.findBetterGuess("con", "cat")); // con - alphabetically greater
    }
}