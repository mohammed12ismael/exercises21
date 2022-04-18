public class Main {
    public static void main(String[] args) {
        String[] ingredients1 = {"1 tablespoon olive oil", "1 pound lean ground beef",
                "1.5 cups of water", "1 (6 ounce) can tomato paste",
                "4 green bell peppers, tops and seeds removed"};
        Recipe recipe1 = new Recipe("Beef-Stuffed Peppers", ingredients1, 55, 4);

        String[] ingredients2 = {"Sugar", "Water", "Lemon Juice", "Ice"};
        Recipe recipe2 = new Recipe("Lemonade", ingredients2, 15, 10);

        recipe1.printRecipe(); // expected output
        recipe2.printRecipe(); // expected output
    }
}
