package Grocery;
import java.util.Scanner;

class Delivery{
  String day;
  String time;
  Scanner usrIn = new Scanner(System.in);
  //Gets the day for delivery with infinite loop until correct option chosen.
  void getDayForDeliver(){
    boolean verified = false;
    while(!verified){
      System.out.println("Please input the day of the week you wish to have your groceries deliverd.");
      System.out.println("Monday, Tuesday, Wednesday, Thursday, Friday, Sat, Sunday");
      switch(userIn.nextLine()){
        case "Monday": day = "Monday"; verified = true; break;
        case "Tuesday": day = "Tuesday"; verified = true; break;
        case "Wednesday": day = "Wednesday"; verified = true; break;
        case "Thursday": day = "Thursday"; verified = true; break;
        case "Friday": day = "Friday"; verified = true; break;
        case "Saturday": day = "Saturday"; verified = true; break;
        case "Sunday": day = "Sunday"; verified = true; break;
        default:
          System.out.println("The Day you entered does not match our options.");
      }
    }
  }
  //Gets the time for delivery with infinite loop until correct option chosen.
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
