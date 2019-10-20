
import java.util.*;

public class User {
    private String name;
    private String address;
    private String email;
    private int creditCard;
    private List<Listing> listings;
    private List<Listing> marketPlace;

    public User(String name, String address, String email, int creditCard, List<Listing> marketPlace) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.creditCard = creditCard;
        listings = new ArrayList<Listing>();
        this.marketPlace = marketPlace;
    }

    public String toString() {
        return "Name:" + name + "\nAddress: " + address + "\nEmail: " + email
                + "\nCredit Card: " + creditCard + "\nListings: " + listings.toString();
    }

    public String getName() {
        return name;
    }

    //returns the smallest listing on the market place larger than the given
    //      amount. If no listings are larger than the given amount, the largest
    //      listing possible will be returned. Empty market place results in a
    //      IllegalArgumentException being thrown.
    public Listing find(int amount) {
        if (marketPlace.size() >= 1) {
            for (Listing l : marketPlace) {
                if (l.getAmount() >= amount) {
                    return l;
                } else if (l.equals(marketPlace.get(marketPlace.size() - 1))) {
                    return l;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    //posts a new listing on the marketplace
    public void post(Listing input) {
        marketPlace.add(input);
        Collections.sort(marketPlace);
    }
}
