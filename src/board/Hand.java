package board;

import java.util.ArrayList;
import cards.*;

public class Hand implements Displayable {
    private ArrayList<Card> handList = new ArrayList<Card>();

    public void add(Card this_card){
        handList.add(this_card);
    }
    public int size(){
        return handList.size();
    }
    public Card getElementAt(int this_location){
        return handList.get(this_location);
    }
    public Card removeElement(int this_element){
        return handList.remove(this_element);
    }
}
