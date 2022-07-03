package WorkingWithAbstraction.CardsWithPower;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);
    private  int suitPower;

    public int getSuitPower() {
        return suitPower;
    }

    CardSuit(int suitPower) {
        this.suitPower = suitPower;
    }
}
