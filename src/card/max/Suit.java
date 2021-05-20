package card.max;

public enum Suit {

    SPADE("♠"), HEART("♥"), DIAMOND("♦"), CLUB("♣");

    private final String value;

    Suit(String value) {
        this.value = value;
    }

    public String getSuitValue() {
        return value;
    }
}
