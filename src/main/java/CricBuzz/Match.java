package CricBuzz;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private String matchId;
    private Team team1, team2;
    private MatchFormat format;
    private MatchStatus status;
    private ScoreBoard scoreBoard;
    private List<Observer> observers;

    public Match(String matchId, Team team1, Team team2, String formatType){
        this.matchId=matchId;
        this.team1=team1;
        this.team2= team2;
        this.format= MatchFactory.getMatchFormat(formatType);
        this.status= MatchStatus.UPCOMING;
        this.scoreBoard=ScoreBoard.getInstance();
        this.observers= new ArrayList<>();
    }

    public void startMatch(){
        this.status=MatchStatus.LIVE;
        notifyObservers("Match started: " + team1.getName() + "vs" +team2.getName());
    }

    public void updateScore(int run, BallType ballType){
        scoreBoard.updateScore(run, ballType);
        notifyObservers("Score update: "+ scoreBoard.getScore());
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(String message){
        for(Observer observer: observers){
            observer.update(message);
        }
    }
}
