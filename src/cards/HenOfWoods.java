package cards;

public class HenOfWoods extends Mushroom {
    public static void main (String[] args){}
    public HenOfWoods(){}
    public HenOfWoods(CardType this_type){
        super(this_type,"henofwoods");
        super.flavourPoints = 3;
        return;
    }
}