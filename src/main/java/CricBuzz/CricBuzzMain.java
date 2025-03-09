package CricBuzz;

import java.util.Arrays;

public class CricBuzzMain {
    public static void main(String[] args) {
        Player p1= new Player("Virat Kohli");
        Player p2= new Player("Bumrah");

        Team india= new Team("India", Arrays.asList(p1, p2));
        Team australia= new Team("Australia", Arrays.asList(new Player("Warner"), new Player("Smith")));

        Match match1= new Match("001", india, australia, "T20");
        Match match2= new Match("002", india, australia, "ODI");

        User user1= new User("Alice");
        User user2= new User("Bob");
        match1.addObserver(user1);
        match1.addObserver(user2);

        match1.startMatch();

        match1.updateScore(4, BallType.NORMAL);
        match1.updateScore(6,  BallType.NORMAL);
        match1.updateScore(0, BallType.WICKET);

        ScoreBoard sb1= ScoreBoard.getInstance();
        ScoreBoard sb2= ScoreBoard.getInstance();

        System.out.println("ScoreBoard instance Match 1: " + sb1.hashCode());
        System.out.println("ScoreBoard instance Match 2: " + sb2.hashCode());

        // If Singleton is working correctly, both should have the same hashCode.

    }
}
