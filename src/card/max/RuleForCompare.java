package card.max;



public class RuleForCompare
{
    private Object Suit;
    private Object Number;

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        Cards other = (Cards) obj;
 
        if (Suit==(other.getSuit()))
            return true;
        else if (Number == (other.getNumber()))
            return true;
        return false;
    }
}
