package cards;

class EdibleItem extends Card {
    protected int flavourPoints = 0;
    public static void main (String[] args){}
    public EdibleItem(){
        super();
    }
    public EdibleItem(CardType this_type, String this_name){
        super(this_type, this_name);
    }
    public int getFlavourPoints(){
        return flavourPoints;
    }
}