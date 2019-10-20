
public class Listing implements Comparable<Listing> {
    private int amount;
    private int days;
    private double interest;
    private User owner;

    public Listing(int amount, int days, double interest, User owner) {
        this.amount = amount;
        this.days = days;
        this.interest = interest;
        this.owner = owner;
    }

    public int getAmount(){
        return amount;
    }

    public String toString() {
        return "Name: " + owner.getName()+"\nAmount: $" + amount + "\nDays to pay off loan: " + days
                + "\nInterest rate: " + interest + "% \n" + "-------------------------------------------\n";
    }

    @Override
    public int compareTo(Listing other) {
        if (amount < other.amount) {
            return -1;
        } else if (amount > other.amount){
            return 1;
        } else {
            if (interest < other.interest) {
                return -1;
            } else if (interest > other.interest) {
                return 1;
            } else {
                if (days < other.days) {
                    return -1;
                } else if (days > other.days) {
                    return 1;
                } else {
                    return owner.getName().compareTo(other.owner.getName());
                }
            }
        }
    }
}
