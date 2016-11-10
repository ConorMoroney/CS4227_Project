package Momento;

/**
 * Created by shane on 09-Nov-16.
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
