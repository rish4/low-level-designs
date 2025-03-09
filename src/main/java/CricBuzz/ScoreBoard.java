package CricBuzz;

public class ScoreBoard {
    private static ScoreBoard instance;
    private int totalRuns;
    private int wickets;
    private int overs;

    private ScoreBoard(){
        this.totalRuns= 0;
        this.wickets=0;
        this.overs=0;
    }

    public static ScoreBoard getInstance(){
        if(instance==null){
            instance= new ScoreBoard();
        }
        return instance;
    }

    public String getScore(){
        return "Runs: "+ totalRuns + ", Wickets: "+wickets+ ", Overs: "+ overs;
    }

    public void updateScore(int runs, BallType ballType){
        if(ballType== BallType.WICKET){
            wickets++;
        }else{
            totalRuns+=runs;
        }
    }
}
