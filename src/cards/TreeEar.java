package cards;

public class TreeEar extends Mushroom {
    public static void main (String[] args){}
    public TreeEar(){}
    public TreeEar(CardType this_type){
        super(this_type,"treeear");
        super.flavourPoints = 1;
        super.sticksPerMushroom = 2;
        return;
    }
}