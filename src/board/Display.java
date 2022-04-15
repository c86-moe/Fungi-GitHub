package board;

import java.util.ArrayList;
import cards.*;

public class Display implements Displayable {
    private ArrayList<Card> displayList = new ArrayList<Card>();

    public void add(Card this_card){
        displayList.add(this_card);
    }
    public int size(){
        return displayList.size();
    }
    public Card getElementAt(int this_location){
        return displayList.get(this_location);
    }
    public Card removeElement(int this_element){
        return displayList.remove(this_element);
    }
}
