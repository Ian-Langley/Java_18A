package Grocery;
public class Ingredient implements Display{
  //Base Variables
  private String name;
  private double cost;
  //Constructor
  public Ingredient(String s, double d){
    name = s;
    cost = d;
  }
  //Data Acces Methods
  public String getName(){
    return name;
  }
  public double getCost(){
    return cost;
  }
  public void setName(String s){
    name = s;
  }
  public void setCost(double d){
    cost = d;
  }
  //Implementation of Display
  public void showName(){
    System.out.println(name);
  }
  public void showCost(){
    System.out.println("Costs :" + cost);
  }
  public void fullDisplay(){
    showName();
    showCost();
  }
  public void showDescription(){}
}
