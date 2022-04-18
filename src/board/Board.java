package board;

import java.util.ArrayList;
import cards.*;

public class Board {
    private static CardPile forestCardPile;
    private static CardList forest;
    private static ArrayList<Card> decayPile;

    public static void initialisePiles() {
        forestCardPile = new CardPile();
        forest = new CardList();
        decayPile = new ArrayList<Card>();
        return;
    }

    public static void setUpCards() {
        for(int i = 0; i < 10; i++) {
            forestCardPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new HoneyFungus(CardType.NIGHTMUSHROOM));
        for(int i = 0; i < 8; i++) {
            forestCardPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new TreeEar(CardType.NIGHTMUSHROOM));
        for(int i = 0; i < 6; i++) {
            forestCardPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new LawyersWig(CardType.NIGHTMUSHROOM));
        for(int i = 0; i < 5; i++) {
            forestCardPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new Shiitake(CardType.NIGHTMUSHROOM));
        for(int i = 0; i < 5; i++) {
            forestCardPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new HenOfWoods(CardType.NIGHTMUSHROOM));
        for(int i = 0; i < 4; i++) {
            forestCardPile.addCard(new BirchBolete(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new BirchBolete(CardType.NIGHTMUSHROOM));
        for(int i = 0; i < 4; i++) {
            forestCardPile.addCard(new Porcini(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new Porcini(CardType.NIGHTMUSHROOM));
        for(int i = 0; i < 4; i++) {
            forestCardPile.addCard(new Chanterelle(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new Chanterelle(CardType.NIGHTMUSHROOM));
        for(int i = 0; i < 3; i++) {
            forestCardPile.addCard(new Morel(CardType.DAYMUSHROOM));
        }
        for(int i = 0; i < 3; i++) {
            forestCardPile.addCard(new Butter());
        }
        for(int i = 0; i < 3; i++) {
            forestCardPile.addCard(new Cider());
        }
        for(int i = 0; i < 11; i++) {
            forestCardPile.addCard(new Pan());
        }
        for(int i = 0; i < 5; i++) {
            forestCardPile.addCard(new Basket());
        }
        return;
    }

    public static CardPile getForestCardsPile() {
        return forestCardPile;
    }

    public static CardList getForest(){
        return forest;
    }

    public static ArrayList<Card> getDecayPile() {
        return decayPile;
    }
    
    public static void updateDecayPile(){
        if(decayPile.size() >= 4){
            decayPile.clear();
        }
        decayPile.add(forest.removeCardAt(1));
        //forest.removeCardAt(1);
        //while(forest.size() < 8 && forestCardPile.pileSize() >0){
        //    forest.add(forestCardPile.drawCard());
        //}
        return;
    }

    public static Card removeFromForest(int index){
        return forest.removeCardAt(index);  
    }
}
