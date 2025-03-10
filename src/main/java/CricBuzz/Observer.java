package CricBuzz;

interface Observer {
    void update(String message);
}

class User implements Observer{
    private String name;

    public User(String name){
        this.name=name;
    }

    public void update(String message){
        System.out.println(name+ " received notification: " + message);
    }
}
