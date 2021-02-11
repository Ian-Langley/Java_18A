package Grocery;

class Meal extends Ingrediant(){
  String mealName;
  String description;
  Ingrediant ingredients[] = new Ingredient[];
  private int ingCount = 0;
  private double cost = 0.0;

  //Meal constructor, requires a preInitialized array;
  Meal(String n, int iC, double c, Ingredient[] ing){
    mealName = n;
    ingCount = i;
    cost = c;
    ingredients = ing;
  }

  //Method to add an Ingrediant to the meal
  void addIng(Ingredient new){
    int temp = ingCount++;
    Ingredient tempArray[] = new Ingredient[temp];
    for(int i = 0; temp < n; temp++){
      tempArray[i] = ingredients[i];
    }
    tempArray[temp]  = new;
    ingredients = tempArray;
  }

  //method to calculate total cost of meal based on ingrediants
  //Does not display, only sets cost. New method needs to be made
  void calcCost(){
    for(int i = 0; i < ingCount; i++){
      cost += ingredients[i].getCost();
    }
  }
}
