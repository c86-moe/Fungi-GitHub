package cards;

public public class Card {
    protected CardType type;
    protected String cardName;

    public Card(){}
    
    public Card(CardType this_type, String this_name){
        type = this_type;
        cardName = this_name;
        return;
    }
    public CardType getType(){
        return type;
    }
    public String getName(){
        return cardName;
    }
}
