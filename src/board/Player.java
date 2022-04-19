package board;

import java.util.ArrayList;

import cards.Card;
import cards.CardType;
import cards.EdibleItem;
import cards.Mushroom;

public class Player {
    private Hand h = new Hand();
    private Display d = new Display();
    private int score;
    private int handlimit;
    private int sticks;
    
    public Player(){
        score = 0;
        handlimit = 8;
        sticks = 0;
    }
    
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
        for(int i = 0; i < num_sticks; i++){
            d.add(new cards.Stick());
        }
        getDisplay();
        return;
    }

    public void removeSticks(int num_sticks){
        getDisplay();
        if(sticks<num_sticks){
            return;
        }
        for(int i=0;i<d.size();i++){
            if(d.getElementAt(i).getType()==CardType.STICK){
                d.removeElement(i);
                i--;
                num_sticks--;
                if(num_sticks == 0){
                    getDisplay();
                    return;
                }
            }
        }
        getDisplay();
        return;
    }

    public Hand getHand(){
        return h;
    }

    public Display getDisplay() {
        handlimit = 8;
        sticks = 0;
        for(int i=0; i<d.size(); i++){
            if(d.getElementAt(i).getType()==CardType.BASKET){
                handlimit+=2;
            }
            if(d.getElementAt(i).getType()==CardType.STICK){
                sticks++;
            }
        }
        return d;
    }

    public void addCardtoHand(Card this_card) {
        if(this_card.getType()==CardType.BASKET || this_card.getType()==CardType.STICK){
            addCardtoDisplay(this_card);
        } else {
            h.add(this_card);
        }
        return;
    }

    public void addCardtoDisplay(Card this_card){
        d.add(this_card);
        getDisplay();
        return;
    }

    // Tests passed.
    public boolean takeCardFromTheForest(int this_index){
        getDisplay();
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
    
    // Tests passed.
    public boolean takeFromDecay(){
        int numBaskets = 0;
        ArrayList<Card> decayPile = Board.getDecayPile();
        getDisplay();
        for(Card c : decayPile){
            if(c.getType()==CardType.BASKET){
                numBaskets++;
            }
        }
        if((handlimit+numBaskets*2)>=(h.size()+decayPile.size()-numBaskets)){
            // System.out.println("Decay True : hl="+handlimit+"bk="+numBaskets+"hs="+h.size()+"ds="+decayPile.size());
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
            // System.out.println("Decay False: hl="+handlimit+"bk="+numBaskets+"hs="+h.size()+"ds="+decayPile.size());
            // It appears that tests are not passing for other reasons not related with this code - handlimits are being exceeded.
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

        for(Card c : this_array){
            if(c.getType()==CardType.PAN){
                if(panInList){
                    panInList = true;
                } else {
                    return false;
                }
            }
            if(c.getType()==CardType.DAYMUSHROOM){
                if(mushroomName!="undefined"&&mushroomName!=c.getName()){
                    return false;
                }else{
                    mushroomName=c.getName();
                }
                numMushrooms++;
            }
            if(c.getType()==CardType.NIGHTMUSHROOM){
                if(mushroomName!="undefined"&&mushroomName!=c.getName()){
                    return false;
                }else{
                    mushroomName=c.getName();
                }
                numMushrooms+=2;
            }
            if(c.getType()==CardType.CIDER){
                numCider++;
            }
            if(c.getType()==CardType.CIDER){
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
        if(!panInDisplay && !panInList){
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
                score += ((EdibleItem)c).getFlavourPoints();
                score += ((EdibleItem)c).getFlavourPoints();
            }else{
                score += ((EdibleItem)c).getFlavourPoints();
            }
            if(getHand().removeElement(c)==false){
                System.out.println("Can not remove card specified.");
                return false;
            }
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
                getDisplay().add(h.removeElement(i));
                break;
            }
        }
        return flag;
    }
}
