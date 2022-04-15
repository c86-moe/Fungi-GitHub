package cards;

class Shiitake extends Mushroom {
    public static void main (String[] args){}
    public Shiitake(){}
    public Shiitake(CardType this_type){
        super(this_type,"shittake");
        super.flavourPoints = 2;
        return;
    }
}