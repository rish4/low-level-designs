package CricBuzz;

abstract class MatchFormat {
    int maxOvers;
    int maxPlayers;
    abstract String getFormatName();
}

class T20 extends MatchFormat{
    public T20(){
        this.maxOvers=20;
        this.maxPlayers=11;
    }

    public String getFormatName(){
        return "T20";
    }
}

class ODI extends MatchFormat{
    public ODI(){
        this.maxOvers=50;
        this.maxPlayers=11;
    }

    public String getFormatName(){
        return "ODI";
    }
}

class MatchFactory{
    public static MatchFormat getMatchFormat(String type){
        if(type.equalsIgnoreCase("T20")){
            return new T20();
        }

        else if(type.equalsIgnoreCase("ODI")){
            return new ODI();
        }
        return null;
    }
}


