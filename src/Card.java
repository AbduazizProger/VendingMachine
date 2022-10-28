public class Card {
    private int id;
    private double credit;

    public Card(int id, double credit) {
        this.id = id;
        this.credit = credit;
    }

    public double getCredit() {
        return this.credit;
    }

    public int getId() {
        return this.id;
    }

    public void reCharge(double new_credit) {
        this.credit += new_credit;
    }

    public void shop(double cost) {
        this.credit -= cost;
    }
}
