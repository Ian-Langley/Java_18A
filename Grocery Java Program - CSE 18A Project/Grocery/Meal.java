package Grocery;

class Meal{
  String mealName;
  String description;
  private int ingCount = 0;
  private double cost = 0.0;
  Ingredient ingredients[] = new Ingredient[ingCount];

//Meal constructor, requires a preInitialized array;
  Meal(String n, double c){
    mealName = n;
    cost = c;
  }

  //Method to add an Ingrediant to the meal
  void addIng(Ingredient added){
    int temp = ingCount++;
    Ingredient tempArray[] = new Ingredient[temp];
    for(int i = 0; temp < ingCount; temp++){
      tempArray[i] = ingredients[i];
    }
    tempArray[temp]  = added;
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
