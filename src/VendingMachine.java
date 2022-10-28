import java.util.HashMap;

public class VendingMachine {
    HashMap<String, Bevarages> bevarage_list = new HashMap<String, Bevarages>();
    HashMap<Integer, Card> cardlist = new HashMap<Integer, Card>();
    HashMap<Integer, Coloumn> coloumns = new HashMap<Integer, Coloumn>();

    public VendingMachine() {
    }

    public void addBeverage(String name, double price) {
        Bevarages bevarage = new Bevarages(name, price);
        bevarage_list.put(name, bevarage);
    }

    public double getPrice(String beverageName) {
        if (bevarage_list.containsKey(beverageName)){
            return bevarage_list.get(beverageName).getPrice();
        }
        return -1.0;
    }

    public void rechargeCard(int cardId, double credit) {
        if (cardlist.containsKey(cardId)) {
            cardlist.get(cardId).reCharge(credit);
        } else {
            Card new_card = new Card(cardId, credit);
            cardlist.put(cardId, new_card);
        }
    }

    public double getCredit(int cardId) {
        if (cardlist.containsKey(cardId)) {
            return cardlist.get(cardId).getCredit();
        }
        return -1.0;
    }

    public void refillColumn(int column, String beverageName, int cans) {
        if (!coloumns.containsKey(column)) {
            Coloumn new_coloumn = new Coloumn(column, beverageName, cans);
            coloumns.put(column, new_coloumn);
        } else {
            coloumns.get(column).setNumber(cans);
        }
    }

    public int availableCans(String beverageName) {
        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            if (coloumns.get(i).getName().equals(beverageName)) {
                sum += coloumns.get(i).getNumber();
            }
        }
        return sum;
    }

    public int sell(String beverageName, int cardId) {
        for (int i = 1; i <= 4; i++) {
            if (bevarage_list.containsKey(beverageName)
                    && cardlist.containsKey(cardId)
                    && availableCans(beverageName) > 0
                    && getCredit(cardId) >= getPrice(beverageName)) {
                if (coloumns.get(i).getName().equals(beverageName) && coloumns.get(i).getNumber() > 0) {
                    cardlist.get(cardId).shop(getPrice(beverageName));
                    coloumns.get(i).reduce();
                    return i;
                }
            }
        }
        return -1;
    }
}
