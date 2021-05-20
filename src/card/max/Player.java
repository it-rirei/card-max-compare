package card.max;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String name;
    private final List<Cards> handCards = new ArrayList<>();

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public List<Cards> getHandCards() {
        return handCards;
    }

    public void setHandCards(Cards cards) {
        handCards.add(cards);
    }



    public String getName() {
        return name;
    }



}