package Grocery;
class Ingredient implements Display{
  //Base Variables
  private String name;
  private double cost;
  //Constructor
  Ingredient(String s, double d){
    name = s;
    cost = d;
  }
  //Data Acces Methods
  String getName(){
    return name;
  }
  void setName(String s){
    name = s;
  }
  double getCost(){
    return cost;
  }
  void setCost(double d){
    cost = d;
  }
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
