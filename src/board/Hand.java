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
        // if(this_location<0 || this_location >= handList.size()){
        //     return null;
        // }
        return handList.get(this_location);
    }
    public Card removeElement(int this_element){
        // if(this_element<0 || this_element >= handList.size()){
        //     return null;
        // }
        return handList.remove(this_element);
    }
    public void removeElement(Card this_card){
        handList.remove(this_card);
    }
}
