// Run this file to see how our calendar app works

package folder_sample;

import java.util.Arrays;
import folder_sample.LinkedListAbstract;
import folder_sample.CalendarDay;

public class MainClassLL {
	public static void main(String[] args) {
		
		CalendarDay day1 = new CalendarDay("19Feb", "Monday", true);
        CalendarDay day2 = new CalendarDay("20Feb", "Tuesday", false);
        CalendarDay day3 = new CalendarDay("21Feb", "Wednesday", true);

        // Classes
        String[] classes = {"Math", "History", "English", "Science", "Art", "Geography"};
        try {
        day1.addClass(classes[0]);
        day1.addClass(classes[1]);
        System.out.println("Day 1: "); 
        day1.printCompleteDay();
        System.out.println("******************* \n");
        
        
        day2.addClass(classes[2]);
        day2.addClass(classes[3]);
        day2.addClass(classes[4]);
        System.out.println("Day 2: ");
        day2.printCompleteDay();
        System.out.println("******************* \n");

        day3.addClass(classes[5]);
        System.out.println("Day 3 classes:");
        day3.printCompleteDay();
        
        } catch (Exception e) {
            System.err.println("Error adding class: " + e.getMessage());
        }
        
        System.out.println("*******************\n ");
        
        System.out.println("******************* Adding these days to our linked list ******************** \n");
        
        LinkedListAbstract<CalendarDay> list = new LinkedListAbstract<>();
        list.addLast(day3);
        list.addLast(day2);
        list.addLast(day1);
		
        System.out.println("******************* Successfully these days to our linked list ******************** \n");
        System.out.println("\n");
        System.out.println("******************* Removing day 1 as it's done ******************** \n");
        
		CalendarDay a = list.popFirst();
		System.out.print("The element popped out is : ");
		a.printCompleteDay();
		
		LinkedListAbstract.Node<CalendarDay> current = list.head;
		
		System.out.println("\n");
		System.out.print("The upcoming days now become : ");
		System.out.println("\n");
		while (current != null) {
		current.getElement().printCompleteDay();System.out.println("\n");
		current = current.getNext();
				}
		
	
    }
	
	
}
