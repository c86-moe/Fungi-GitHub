package cards;

public class LawyersWig extends Mushroom {
    public static void main (String[] args){}
    public LawyersWig(){}
    public LawyersWig(CardType this_type){
        super(this_type,"lawyerswig");
        super.flavourPoints = 2;
        return;
    }
}