package Grocery;

class Meal implements Display{
  String mealName;
  String description;
  private int ingCount = 0;
  private double cost = 0.0;
  Ingredient ingredients[] = new Ingredient[ingCount];

//Meal constructor, ingrediants added post construction.
  Meal(String n, String c){
    mealName = n;
    description = c;
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



  //Implementation of Display
  public void showName(){
    System.out.println(mealName);
  }
  public void showCost(){
    System.out.println("Costs :" + cost);
  }
  public void showDescription(){
    System.out.println(description);
  }
  public void fullDisplay(){
    showName();
    showCost();
    showDescription();
  }
}
