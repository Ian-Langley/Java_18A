package Grocery;
import java.util.Random;
import java.util.Scanner;

class Driver{

  public static void main(String[] args) {
    //Variable Delcaration
    boolean chckOut = false, valid;
    int input = 0, index=0, cartSize = 0;
    Scanner usrIn = new Scanner(System.in);
    Random rnd = new Random();
    Delivery recipt = new Delivery();
    Ingredient stockIngredients[];
    stockIngredients = fillIngrCat();
    Meal[] mealCatalog = new Meal[20];
    Meal[] cart = new Meal[cartSize];
    //Filling Catalog From Methods
    for(int i = 0; i<20; i++){
      mealCatalog[i] = genMeal("Food Name", "A clever description", stockIngredients, rnd.nextInt(2)+1);
    }
    //Displaying Menu
    welcm();
    //Print first five meal options
    print5(mealCatalog,index);
    //Display Possible inputs
    options();
    //Loop for while not checking out
    while(!chckOut){
      //try input, catch wrong data type
      try{
        //set correct input cought
        input = usrIn.nextInt();
        valid = true;
        //Formating space
        System.out.println();
        System.out.println();
      }catch(java.util.InputMismatchException e){
        //clear input
        usrIn.nextLine();
        //formating space
        System.out.println();
        System.out.println();
        //Error Message
        System.out.println("!!!!!Please press a corresponding number 1-9!!!!!!");
        //set wrong input cought
        valid = false;
      }
      //While right input is cought, do correct options
      if(valid){
          switch(input){
            //Case 1-5 Identical
            case 1:
              System.out.println("Meal 1 added");
              //add repsective meal to cart
              cart = addMeal(cart,mealCatalog[index+input-1],cartSize);
              cartSize++;
              //format
              System.out.println();
              break;
            case 2:
              System.out.println("Meal 2 added");
              cart = addMeal(cart,mealCatalog[index+input-1],cartSize);
              cartSize++;
              System.out.println();
              break;
            case 3:
              System.out.println("Meal 3 added");
              cart = addMeal(cart,mealCatalog[index+input-1],cartSize);
              cartSize++;
              System.out.println();
              break;
            case 4:
              System.out.println("Meal 4 added");
              cart = addMeal(cart,mealCatalog[index+input-1],cartSize);
              cartSize++;
              System.out.println();
              break;
            case 5:
              System.out.println("Meal 5 added");
              cart = addMeal(cart,mealCatalog[index+input-1],cartSize);
              cartSize++;
              System.out.println();
              break;
            //Page up, displaying next 5 meals
            case 6:
              index += 5;
              if(index >= 20){
                index = 15;System.out.println("No more meals\n");}
                break;
            //Page down, displaying last five meals
            case 7:
              index -= 5;
                if(index <= 0){
                  index = 0;System.out.println("No more meals\n");}
                  break;
            //Begin Checkout
            case 8:
              chckOut = true;
              break;
            //Exit Program
            case 9:
            System.exit(0);
            default:
              System.out.println("!!!!!Please press a corresponding number 1-9!!!!!!");
                break;
          }
        }
        //Redisplay options and menu
        if(!chckOut){
        print5(mealCatalog,index);
        options();
        }
      }
      //Check out
      //Outside of verification due to having internal verificationq
      if(chckOut){
        //Set delivery day
        recipt.getDayForDeliver();
        //Set Delivery time
        recipt.getTimeForDeliver();
        //format space
        System.out.println();
        //Display day, time and fee
        recipt.displayDelivery();
        displayTotal(cart, cartSize);
      }
  }


  //fill predetermined 15 ingredients
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
  //generate x meals randomly from ingredient list
  public static Meal genMeal(String n, String d, Ingredient[] ingr, int number){
      Meal temp = new Meal(n,d);
      Random rnd = new Random();
      for(int i = 0; i<number; i++){
        temp.addIng(ingr[rnd.nextInt(14)]);
      }
      return temp;
    }
  //Welcome message
  private static void welcm(){
    System.out.println();
    System.out.println("Welcome to Grocery Go, for your weekly shoping needs.");
    System.out.println();
  }
  //Options message
  private static void options(){
    System.out.println("********************************************************************");
    System.out.println("1-5: Meal   6: Next Page   7: Previous Page   8: Check Out   9: Exit");
    System.out.println("********************************************************************");
  }
  //Five item list display
  private static void print5(Meal[] meals, int index){
    int cntr = 1;
    for(int i = index; i < index+5; i++){
      System.out.print(cntr + ") ");
      cntr++;
      meals[i].fullDisplay();
    }
  }
  //Add meal to meal arary
  private static Meal[] addMeal(Meal[] cart, Meal added,int cartSize){
    Meal[] temp = new Meal[cartSize+1];
    for(int i=0; i<cartSize; i++){
      temp[i] = cart[i];
    }
    temp[cartSize] = added;
    added.fullDisplay();
    return temp;
  }
  //Display total cost of meal array, requires known size
  private static void displayTotal(Meal[] cart,int cartSize){
    double temp = 0.00;
    for(int i = 0; i < cartSize; i++){
      temp = temp + cart[i].getCost();
    }
    System.out.printf("Total for delivery $%.2f %n", temp);
  }
}
