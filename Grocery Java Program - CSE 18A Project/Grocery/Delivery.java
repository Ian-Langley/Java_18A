package Grocery;
import java.util.Scanner;

class Delivery{
  String day;
  String time;
  Scanner usrIn = new Scanner(System.in);

  void getDayForDeliver(){
    System.out.println("Please input the day of the week you wish to have your groceries deliverd.");
    day = userIn.nextLine();
  }
  void getTimeForDeliver(){
    boolean verified = false;
    while(!verified){
      System.out.println("Please input the time of day you wish to have your groceries deliverd.");
      System.out.println("Morning (8:00 AM), Midday (12:00 PM), Afternoon (4:00 PM), Evening (6:00 PM)");
      switch(userIn.nextLine()){
        case "Morning": time = "8:00 AM"; verified = true; break;
        case "Midday": time = "12:00 PM"; verified = true; break;
        case "Afternoon": time = "4:00 PM"; verified = true; break;
        case "Evening": time = "6:00 PM"; verified = true; break;
        default:
          System.out.println("The time you entered does not match our options.");
      }
    }
  }
  void displayDelivery(){
    System.out.println("Delivery for :" + day + " at " + time);
  }
}
