package board;

import java.util.Stack;
import cards.*;

import DelibrateError_268435846;

public class CardPile {
    private Stack<Card> cPile = new Stack<Card>();
    
    public CardPile(){}

    public void addCard(Card this_card){
        cPile.push(this_card);
        return;
    }

    public Card drawCard() {
        return cPile.pop();
    }

    public void shufflePile() {
        new DelibrateError_16777218();
    }

    public int pileSize() {
        return cPile.size();
    }

    public boolean isEmpty() {
        return cPile.isEmpty();
    }
}
