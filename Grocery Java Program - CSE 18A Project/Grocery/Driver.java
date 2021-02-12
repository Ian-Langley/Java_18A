package Grocery;
import java.util.Random;
import java.util.Scanner;

class Driver{

  public static void main(String[] args) {
    //Variable Delcaration
    boolean chckOut = false, valid;
    int input = 0, index=0;
    Scanner usrIn = new Scanner(System.in);
    Random rnd = new Random();
    Delivery recipt = new Delivery();
    Ingredient stockIngredients[];
    stockIngredients = fillIngrCat();
    Meal[] mealCatalog = new Meal[20];
    //Filling Catalog From Methods
    for(int i = 0; i<20; i++){
      mealCatalog[i] = genMeal("temp", "temp", stockIngredients, rnd.nextInt(2)+1);
    }
    //Displaying Menu
    welcm();
    print5(mealCatalog,index);
    options();
    while(!chckOut){
      try{
        input = usrIn.nextInt();
        valid = true;
        System.out.println();
        System.out.println();
      }catch(java.util.InputMismatchException e){
        usrIn.nextLine();
        System.out.println();
        System.out.println();
        System.out.println("!!!!!Please press a corresponding number 1-8!!!!!!");
        valid = false;
      }
      if(valid){
          switch(input){
            case 1: System.out.println("Meal 1 added");System.out.println();break;
            case 2: System.out.println("Meal 2 added");System.out.println();break;
            case 3: System.out.println("Meal 3 added");System.out.println();break;
            case 5: System.out.println("Meal 5 added");System.out.println();break;
            case 4: System.out.println("Meal 4 added");System.out.println();break;
            case 6: index += 5;if(index > 19){index = 15;System.out.println("No more meals\n");}break;
            case 7: index -= 5;if(index < 0){index = 0;System.out.println("No more meals\n");}break;
            case 8: chckOut = true; break;
            default: System.out.println("!!!!!Please press a corresponding number 1-8!!!!!!");break;
          }
        }
        if(!chckOut){
        print5(mealCatalog,index);
        options();
        }
      }
      if(chckOut){
        recipt.getDayForDeliver();
        recipt.getTimeForDeliver();
        System.out.println();
        recipt.displayDelivery();
      }
  }







  public static Ingredient[] fillIngrCat(){
      Ingredient[] t = new Ingredient[15];
      t[0] = new Ingredient("Carrot",0.99);
      t[1] = new Ingredient("Onioin", 0.54);
      t[2] = new Ingredient("Cellery",1.28);
      t[3] = new Ingredient("Beef",4.48);
      t[4] = new Ingredient("Chicken",3.99);
      t[5] = new Ingredient("Eggs",1.65);
      t[6] = new Ingredient("Fish",3.4);
      t[7] = new Ingredient("Noodles",1.28);
      t[8] = new Ingredient("Cheese",1.6);
      t[9] = new Ingredient("Cream",3.62);
      t[10] = new Ingredient("Herbs",0.53);
      t[11] = new Ingredient("Potatoes",3.07);
      t[12] = new Ingredient("Tomatoes",1.59);
      t[13] = new Ingredient("Stock",1.78);
      t[14] = new Ingredient("Lettuce",2.67);
      return t;
    }
  public static Meal genMeal(String n, String d, Ingredient[] ingr, int number){
      Meal temp = new Meal(n,d);
      Random rnd = new Random();
      for(int i = 0; i<number; i++){
        temp.addIng(ingr[rnd.nextInt(14)]);
      }
      return temp;
    }
  private static void welcm(){
    System.out.println();
    System.out.println("Welcome to Grocery Go, for your weekly shoping needs.");
    System.out.println();
  }
  private static void options(){
    System.out.println("**********************************************************");
    System.out.println("1-5: Meal   6: Next Page   7: Previous Page   8: Check Out");
    System.out.println("**********************************************************");
  }
  private static void print5(Meal[] meals, int index){
    if(index == 0){
      for(int i = 0; i < 5; i++){
        meals[i].fullDisplay();
      }
    }else
    for(int i = index-5; i < index; i++){
      meals[i].fullDisplay();
    }
  }
}
