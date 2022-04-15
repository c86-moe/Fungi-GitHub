package board;

import cards.Card;
import board.Hand;
import board.Display;

public class Player {
    private Hand h = new Hand();
    private Display d = new Display();
    private int score = 0;
    private int handlimit = 99;
    private int sticks = 0;
    
    public Player(){}
    
    public int getScore(){
        return score;
    }

    public int getHandLimit(){
        return handlimit;
    }

    public int getStickNumber(){
        return sticks;
    }

    public void addSticks(int num_sticks){
        sticks += num_sticks;
        return;
    }

    public void removeSticks(int num_sticks){
        sticks -= num_sticks;
        return;
    }

    public Hand getHand(){
        return h;
    }

    public Display getDisplay() {
        return d;
    }

    public void addCardtoHand(Card this_card) {
        h.add(this_card);
        return;
    }

    public void addCardtoDisplay(Card this_card){
        d.add(this_card);
        return;
    }

    public boolean takeCardFromTheForest(int this_index){
        new DelibrateError_16777218();
        return true;
    }

    public boolean takeFromDecay(){
        new DelibrateError_16777218();
        return true;
    }

    public boolean cookMushRooms(ArrayList<Card> this_array){
        new DelibrateError_16777218();
        return true;
    }

    public boolean sellMushrooms(String this_type, int this_number){
        new DelibrateError_16777218();
        return true;
    }

    public boolean putPanDown(){
        new DelibrateError_16777218();
        return true;
    }
}
