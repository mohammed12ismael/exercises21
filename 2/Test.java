public class Test
{
    public static void main(String[] args)
    {
        String[] beefIngredients = {"1 tablespoon olive oil", "1 pound lean ground beef",
                "1.5 cups of water", "1 (6 ounce) can tomato paste",
                "4 green bell peppers, tops and seeds removed"};
        Recipe beef = new Recipe("Beef-Stuffed Peppers", beefIngredients, 55, 4);

        String[] lemonadeIngredients = {"Sugar", "Water", "Lemon Juice", "Ice"};
        Recipe lemonade = new Recipe("Lemonade", lemonadeIngredients, 15, 10);

        /*
        * Name: Beef-Stuffed Peppers
        * Preparation Time: 55 (Minutes)
        * Servings: 4
        * Ingredients:
        * . 1 tablespoon olive oil
        * . 1 pound lean ground beef
        * . 1.5 cups of water
        * . 1 (6 ounce) can tomato paste
        * . 4 green bell peppers, tops and seeds removed
        * */
        beef.printRecipe();

        /*
        * Name: Lemonade
        * Preparation Time: 15 (Minutes)
        * Servings: 10
        * Ingredients:
        * . Sugar
        * . Water
        * . Lemon Juice
        * . Ice
        * */
        lemonade.printRecipe();
    }
}
