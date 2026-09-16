// Save this as Main.java and Run the Main class

class Level {
    private boolean goalReached;
    private int points;

    public Level(boolean goalReached, int points) {
        this.goalReached = goalReached;
        this.points = points;
    }

    public boolean goalReached() {
        return goalReached;
    }

    public int getPoints() {
        return points;
    }
    
    // for simulation
    public void setGoal(boolean reached, int pts) {
        this.goalReached = reached;
        this.points = pts;
    }
}

class Game {
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;
    private boolean bonus;

    public Game() {
        // start with empty levels
        levelOne = new Level(false, 0);
        levelTwo = new Level(false, 0);
        levelThree = new Level(false, 0);
        bonus = false;
    }

    public boolean isBonus() {
        return bonus;
    }

    // Simulates playing the game - randomizes levels for demo
    public void play() {
        // This is just for testing - in the real FRQ this method is provided
        // Randomly decide if goals are reached
        levelOne.setGoal(Math.random() > 0.2, 100);
        levelTwo.setGoal(Math.random() > 0.4, 150);
        levelThree.setGoal(Math.random() > 0.6, 200);
        bonus = Math.random() > 0.7;
    }

    // (a) SOLUTION
    public int getScore() {
        int score = 0;

        if (levelOne.goalReached()) {
            score += levelOne.getPoints();
            if (levelTwo.goalReached()) {
                score += levelTwo.getPoints();
                if (levelThree.goalReached()) {
                    score += levelThree.getPoints();
                }
            }
        }

        if (isBonus()) {
            score *= 3;
        }

        return score;
    }

    // (b) SOLUTION
    public int playManyTimes(int num) {
        int maxScore = 0;
        for (int i = 0; i < num; i++) {
            play();
            int currentScore = getScore();
            if (i == 0 || currentScore > maxScore) {
                maxScore = currentScore;
            }
        }
        return maxScore;
    }
}

public class Main {
    public static void main(String[] args) {
        Game g = new Game();

        // Manual test for part (a)
        // Set levels manually to check logic
        System.out.println("--- Part (a) Test ---");
        // This is a simple manual test, normally play() sets this
        
        // Simulate a game where you beat all 3 levels and it's bonus
        // You would need getters/setters for a perfect manual test,
        // so we will just call playManyTimes

        System.out.println("--- Part (b) Test playManyTimes(4) ---");
        int highest = g.playManyTimes(4);
        System.out.println("Highest score in 4 plays: " + highest);

        System.out.println("\n--- Playing 10 times and showing each score ---");
        for(int i=0; i<10; i++){
            g.play();
            System.out.println("Game " + (i+1) + " score: " + g.getScore() + " (Bonus: " + g.isBonus() + ")");
        }
        
        System.out.println("\nHighest of 100 games: " + g.playManyTimes(100));
    }
}