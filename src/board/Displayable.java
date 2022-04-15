package board;
import cards.Card;

public interface Displayable{
    public void add(Card this_card);
    public int size();
    public Card getElementAt(int this_location);
    public Card removeElement(int this_element);
}