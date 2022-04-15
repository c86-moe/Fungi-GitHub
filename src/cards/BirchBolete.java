package cards;

public class BirchBolete extends Mushroom {
    public static void main (String[] args){}
    public BirchBolete(){}
    public BirchBolete(CardType this_type){
        super(this_type,"birchbolete");
        super.flavourPoints = 3;
        super.sticksPerMushroom = 2;
        return;
    }
}