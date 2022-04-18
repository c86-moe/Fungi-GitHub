package board;

import java.util.ArrayList;

import cards.Card;
import cards.CardType;
import cards.EdibleItem;
import cards.Mushroom;

public class Player {
    private Hand h = new Hand();
    private Display d = new Display();
    private int score = 0;
    private int handlimit = 8;
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
        for(int i = 0; i < num_sticks; i++){
            d.add(new cards.Stick());
        }
        return;
    }

    public void removeSticks(int num_sticks){
        sticks -= num_sticks;
        for(int i=0;i<d.size();i++){
            if(d.getElementAt(i).getType()==CardType.STICK){
                d.removeElement(i);
                i--;
                num_sticks--;
                if(num_sticks == 0){
                    return;
                }
            }
        }
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
        if(this_card.getType() == CardType.BASKET){
            handlimit += 2;   
        }
        if(this_card.getType() == CardType.STICK){
            sticks++;   
        }
        d.add(this_card);
        return;
    }

    // Tests not passing.
    public boolean takeCardFromTheForest(int this_index){
        if(this_index<=0 || this_index>Board.getForest().size()){
            return false;
        }

        int sticksRequired = 0;
        if(this_index > 2){
            // Need sticks
            sticksRequired = this_index - 2;
            if(sticks<sticksRequired){
                return false;
            }
        }

        Card this_card = Board.getForest().getElementAt(Board.getForest().size()-this_index);
        if(this_card.getType() != CardType.BASKET){
            if(h.size()<handlimit){
                addCardtoHand(this_card);
            }
            else{
                return false;
            }
        }else{
            addCardtoDisplay(this_card);
        }
        Board.removeFromForest(this_index);

        if(sticksRequired>0){
            removeSticks(sticksRequired);
        }
        return true;
    }

    // Tests not passing.
    public boolean takeFromDecay(){
        int numBaskets = 0;
        ArrayList<Card> decayPile = Board.getDecayPile();
        for(Card c : decayPile){
            if(c.getType()==CardType.BASKET){
                numBaskets++;
            }
        }
        if((handlimit+numBaskets*2)>=(h.size()+decayPile.size()-numBaskets)){
            for(Card c : decayPile){
                if(c.getType()==CardType.BASKET){
                    addCardtoDisplay(c);
                } else {
                    addCardtoHand(c);
                }
            }
            decayPile.clear();
            return true;
        }else{
            return false;
        }
    }

    // Tests not passing.
    public boolean cookMushrooms(ArrayList<Card> this_array){
        boolean panInList = false;
        boolean panInDisplay = false;
        int numCider = 0;
        int numButter = 0;
        int numMushrooms = 0;
        String mushroomName = "undefined";
        for(int i=0;i<this_array.size();i++){
            if(this_array.get(i).getType()==CardType.PAN){
                if(panInList){
                    panInList = true;
                } else {
                    return false;
                }
            }
            if(this_array.get(i).getType()==CardType.DAYMUSHROOM){
                if(mushroomName!="undefined"&&mushroomName!=this_array.get(i).getName()){
                    return false;
                }else{
                    mushroomName=this_array.get(i).getName();
                }
                numMushrooms++;
            }
            if(this_array.get(i).getType()==CardType.NIGHTMUSHROOM){
                if(mushroomName!="undefined"&&mushroomName!=this_array.get(i).getName()){
                    return false;
                }else{
                    mushroomName=this_array.get(i).getName();
                }
                numMushrooms+=2;
            }
            if(this_array.get(i).getType()==CardType.CIDER){
                numCider++;
            }
            if(this_array.get(i).getType()==CardType.CIDER){
                numButter++;
            }
        }
        for(int i=0;i<d.size();i++){
            if(d.getElementAt(i).getType()==CardType.PAN){
                panInDisplay = true;
                break;
            }
        }
        // Eligiability Check:
        if(!(panInDisplay && panInList)){
            return false;
        }
        if(numMushrooms<3){
            return false;
        }
        if(numMushrooms<(4*numButter+5*numCider)){
            return false;
        }
        for(Card c : this_array){
            if(c.getType()==CardType.NIGHTMUSHROOM){
                score += ((EdibleItem)c).getFlavourPoints()*2;
            }else{
                score += ((EdibleItem)c).getFlavourPoints();
            }
            h.removeElement(c);   
        }
        return true;
    }

    // Tests not passing.
    public boolean sellMushrooms(String this_type_str, int this_quantity){
        if(this_quantity<2){
            //System.out.println("Too few items to sell.");
            return false;
        }
        boolean hasNight=false;
        int typeCount = 0;
        // For some unknown reason, strings does not match.
        // System.out.println("Looking for: "+this_type_str);
        for(int i=0;i<h.size();i++){
            // System.out.println(h.getElementAt(i).getName());
            if(h.getElementAt(i).getName().equals(this_type_str)){
                // System.out.println("Mushroom named found.");
                if(h.getElementAt(i).getType()==CardType.DAYMUSHROOM){
                    typeCount++;
                }
                if(h.getElementAt(i).getType()==CardType.NIGHTMUSHROOM){
                    typeCount+=2;
                    hasNight=true;
                }
            }
        }
        if(typeCount<this_quantity){
            // System.out.println("Not enough items to sell.");
            return false;
        }

        if(hasNight){
            for(int i=0;i<h.size();i++){
                if(h.getElementAt(i).getName().equals(this_type_str)){
                    if(h.getElementAt(i).getType()==CardType.NIGHTMUSHROOM){
                        addSticks(((Mushroom)h.getElementAt(i)).getSticksPerMushroom()*2);
                        h.removeElement(i);
                        i--;
                        this_quantity-=2;
                    }
                    if(this_quantity<=0){
                        return true;
                    }
                }
            }
        }

        for(int i=0;i<h.size();i++){
            if(h.getElementAt(i).getName().equals(this_type_str)){
                if(h.getElementAt(i).getType()==CardType.DAYMUSHROOM){
                    addSticks(((Mushroom)h.getElementAt(i)).getSticksPerMushroom());
                    h.removeElement(i);
                    i--;
                    this_quantity--;
                }
                if(this_quantity<=0){
                    return true;
                }
            }
        }
        // System.out.println("Unable to process.");
        return false;
    }

    // Working.
    public boolean putPanDown(){
        int hand_size = h.size();
        boolean flag = false;
        for(int i=0;i<hand_size;i++){
            if(h.getElementAt(i).getType()==CardType.PAN){
                flag = true;
                d.add(h.removeElement(i));
                break;
            }
        }
        return flag;
    }
}
