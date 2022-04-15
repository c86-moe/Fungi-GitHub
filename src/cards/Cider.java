package cards;

public class Cider extends EdibleItem {
    public static void main (String[] args){}
    public Cider(){
        super(CardType.CIDER, "cider");
        super.flavourPoints = 5;
        return;
    }
}