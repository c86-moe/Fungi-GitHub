package board;

import java.util.ArrayList;
import cards.*;

public class CardList {
    private ArrayList<Card> cList = new ArrayList<Card>();

    public CardList(){}

    public void add(Card this_card) {
        cList.add(this_card);
    }

    public int size() {
        return cList.size();
    }

    public Card getElementAt(int this_index){
        return cList.get(this_index-1);
    }

    public Card removeCardAt(int this_index){
        return cList.remove(this_index-1);
    }
}
