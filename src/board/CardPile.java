package board;

import java.util.Stack;
import java.util.Random;
import cards.*;

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
        final Random random = new Random();
        int random_result;
        Card temp;
        for(int i = 0; i < cPile.size(); i++){
            random_result = random.nextInt(cPile.size());
            temp = cPile.get(random_result);
            cPile.remove(random_result);
            cPile.add(temp);
        }
        return;
    }

    public int pileSize() {
        return cPile.size();
    }

    public boolean isEmpty() {
        return cPile.isEmpty();
    }
}
