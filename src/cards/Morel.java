package cards;

class Morel extends Mushroom {
    public static void main (String[] args){}
    public Morel(){}
    public Morel(CardType this_type){
        super(this_type,"morel");
        super.flavourPoints = 6;
        return;
    }
}