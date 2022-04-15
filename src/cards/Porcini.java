package cards;

public class Porcini extends Mushroom {
    public static void main (String[] args){}
    public Porcini(){}
    public Porcini(CardType this_type){
        super(this_type,"porcini");
        super.flavourPoints = 3;
        return;
    }
}