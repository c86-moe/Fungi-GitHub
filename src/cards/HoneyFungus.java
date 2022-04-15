package cards;

public class HoneyFungus extends Mushroom {
    public static void main (String[] args){}
    public HoneyFungus(){}
    public HoneyFungus(CardType this_type){
        super(this_type,"honeyfungus");
        super.flavourPoints = 1;
        super.sticksPerMushroom = 1;
        return;
    }
}