package CricBuzz;

public class Player {
    private String name;
    private int runs;
    private int wickets;

    public Player(String name){
        this.name=name;
        this.runs=0;
        this.wickets=0;
    }

    public String getName(){
        return name;
    }

    public void updateStats(int runs, int wickets){
        this.runs+=runs;
        this.wickets+=wickets;
    }
}
