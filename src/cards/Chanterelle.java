package cards;

public class Chanterelle extends Mushroom {
    public static void main (String[] args){}
    public Chanterelle(){}
    public Chanterelle(CardType this_type){
        super(this_type,"chanterelle");
        super.flavourPoints = 4;
        super.sticksPerMushroom = 2;
        return;
    }
}