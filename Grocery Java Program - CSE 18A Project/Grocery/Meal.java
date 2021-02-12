package Grocery;
import java.util.Random;

public class Meal implements Display{
  String mealName;
  String description;
  private int ingCount = 0;
  double cost = 0.0;
  Ingredient ingredients[] = new Ingredient[ingCount];
  //Meal constructor, ingrediants added post construction.
  public Meal(String n, String c){
    mealName = n;
    description = c;
  }
  //Method to add an Ingrediant to the meal
  public void addIng(Ingredient added){
    Ingredient tempArray[] = new Ingredient[ingCount+1];
      for(int i = 0; i < ingCount; i++){
        tempArray[i] = ingredients[i];
      }
    ingCount++;
    tempArray[ingCount-1]  = added;
    ingredients = tempArray;
    calcCost();
  }

  //method to calculate total cost of meal based on ingrediants
  //Does not display, only sets cost. New method needs to be made
  public void calcCost(){
    double temp = cost;
    double diff = cost;
    for(int i = 0; i < ingCount; i++){
      cost += ingredients[i].getCost();
    }
    diff = cost - temp;
    cost = temp + diff;
  }
  //Implementation of Display
  public void showName(){
    System.out.println("Name: " + mealName);
  }
  public void showCost(){
    System.out.println("Costs: " + cost);
  }
  public void showDescription(){
    System.out.print("Ingredients: ");
    for(int i = 0; i < ingCount; i++){
      System.out.print(ingredients[i].getName() + " ");
    }
    System.out.println();
  }
  public void fullDisplay(){
    showName();
    showCost();
    showDescription();
    System.out.println();
  }
}
