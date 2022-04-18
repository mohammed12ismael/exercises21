
public class Recipe {

    String name;
    String[] ingredients;
    int preparationTime;
    int servings;

    public Recipe(String n, String[] ing, int prep, int serv) {
        name = n;

        // copying the array
        ingredients = new String[ing.length];
        for (int i = 0; i < ing.length; i++){
            ingredients[i] = ing[i];
        }

        preparationTime = prep;
        servings = serv;
    }

    public void printRecipe(){
        System.out.println("Name: " + name);
        System.out.println("Preparation Time: " + preparationTime + " Minutes");
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients: ");
        for (int i = 0; i < ingredients.length; i++){
            System.out.println("\t" + ingredients[i]);
        }

    }
}
