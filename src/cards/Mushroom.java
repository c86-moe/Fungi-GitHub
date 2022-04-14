class Mushroom extends EdibleItem {
    protected int sticksPerMushroom;
    public static void main (String[] args){}
    public Mushroom(){}
    public Mushroom(CardType this_type, String this_name){
        super.EdibleItem(this_type, this_name);
    }
    public int getSticksPerMushroom(){
        return sticksPerMushroom;
    }
}