import java.util.*;

class CardCollection {
    private Map<String, List<String>> cards;

    public CardCollection() {
        cards = new HashMap<>();
    }

    public void addCard(String symbol, String cardName) {
        cards.putIfAbsent(symbol, new ArrayList<>());
        cards.get(symbol).add(cardName);
    }

    public List<String> getCardsBySymbol(String symbol) {
        return cards.getOrDefault(symbol, new ArrayList<>());
    }

    public void displayAllCards() {
        for (Map.Entry<String, List<String>> entry : cards.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        collection.addCard("Hearts", "Ace");
        collection.addCard("Hearts", "King");
        collection.addCard("Spades", "Queen");
        collection.addCard("Diamonds", "Jack");
        collection.addCard("Clubs", "10");

        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Find Cards by Symbol");
            System.out.println("2. Display All Cards");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter symbol (Hearts, Spades, Diamonds, Clubs): ");
                    String symbol = scanner.nextLine();
                    List<String> foundCards = collection.getCardsBySymbol(symbol);
                    if (foundCards.isEmpty()) {
                        System.out.println("No cards found for symbol: " + symbol);
                    } else {
                        System.out.println("Cards in " + symbol + ": " + foundCards);
                    }
                    break;
                case 2:
                    collection.displayAllCards();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}