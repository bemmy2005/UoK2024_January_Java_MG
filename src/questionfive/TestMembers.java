package questionfive;

public class TestMembers {
    public static void main(String[] args) {
        // Test Adults
        System.out.println("Testing Adults:");
        Adults adult1 = new Adults(101, "John Doe", "1234567890", 100.0, 2.0);
        adult1.display();

        Adults adult2 = new Adults();
        adult2.insert(102, "Jane Smith", "9876543210", 150.0, 3.0);
        adult2.display();

        // Test Kids
        System.out.println("\nTesting Kids:");
        Kids kid1 = new Kids(201, "Alice", "1112223333", 80.0, 4.0);
        kid1.display();

        Kids kid2 = new Kids();
        kid2.insert(202, "Bob", "4445556666", 120.0, 5.0);
        kid2.display();
    }
}

