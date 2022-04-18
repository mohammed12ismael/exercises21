public class Recipe
{
    String name;
    int preparationTime;
    int servings;
    String[] ingredients;

    public Recipe(String n, String[] ing, int prep, int serv)
    {
        name = n;
        preparationTime = prep;
        servings = serv;
        ingredients = ing.clone(); // copying the array instead of assigning it
    }

    public void printRecipe()
    {
        System.out.println("Name: " + name);
        System.out.println("Preparation Time: " + preparationTime + " (Minutes)");
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients: ");

        for (int i = 0; i < ingredients.length; i++)
            System.out.println(". " + ingredients[i]);
    }
}
