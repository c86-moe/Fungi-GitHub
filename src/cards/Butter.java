package cards;

public class Butter extends EdibleItem {
    public static void main (String[] args){}
    public Butter(){
        super(CardType.BUTTER, "Butter");
        super.flavourPoints = 3;
        return;
    }
}