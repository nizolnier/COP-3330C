/* Nicole Zolnier - 02/26/2022
Homework 4  - 5 names list
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// inside homework4, i have main and 3 auxiliary methods that connect with the other class
public class Homework4 {
    public static void main(String[] args) throws Exception {
        // declaring the scanner and the namesList from class Names
        Scanner input = new Scanner(System.in);
        Names namesList = new Names();

        // asking the user to enter how many names and scanning the answer
        System.out.println("Enter how many name(s) you have:");
        int ans = input.nextInt();

        // while the answer is not -1 (which would exit the program)...
        while (ans != -1) {
            // if the answer is a positive number between 1 and 5 then i can move to the createNames and the second loop
            if (ans > 0 && ans <= 5) {
                // function to create the names
                createNames(ans, namesList);
                // after creating, i offer the user to change one of the names
                loopChangeNames(namesList);
                break;
            } else {
                // if the answer is less than 0 or more than 5 then i ask the use to reenter how many names
                System.out.println("Sorry, you can't have more than 5 names stored in our system! Enter -1 to exit this program.\n");
                System.out.println("Enter how many name(s) you have:");
                ans = input.nextInt();
            }

        }
        System.out.println("Bye!");
    }

    public static void createNames(int num, Names namesList) {
        // scanning the names by getting the entire line
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your " + num + " names separated by + then hit the Enter Key:");
        String names = input.nextLine();

        // here is where the fun starts
        // first i remove any extra spaces and just leave 1 between each word
        // then i put everything in an upper case
        // and then i split by the + sign
        String[] namesArray = names.replaceAll("\\s+", " ").toUpperCase().split("\\+");

        // if the length is bigger than the number than i apologize and restart the method
        // (i used a lot of recursion all throughout this program)
        if (namesArray.length > num) {
            System.out.println("Sorry, you entered more names than what you said you had");
            createNames(num, namesList);
        } else {
            // now i add the names to the arrayList inside the class Names
            for (String n : namesArray) {
            // but first i trim any spaces at the start or at the end of the string
            namesList.add(n.trim());
            }

            // then i print by using the toString method of the class
            System.out.println("You entered:");
            System.out.println(namesList.toString());
        }
        
    }

    public static void loopChangeNames(Names namesList) {
        // ask if the user want to change anything and scan the answer
        Scanner input = new Scanner(System.in);
        System.out.println(
                "\nDo you want to make a change to any of the entered names (enter y/Y for yes or e/E to Exit program):");
        String ans = input.nextLine();

        // while the answer is not e or E
        while (!ans.equals("e") || !ans.equals("E")) {
            // if it is Y or y, i send the next function
            if (ans.equals("Y") || ans.equals("y")) {
                editNames(namesList);
            } else if (ans.equals("e") || ans.equals("E")) {
                // ok so my while loop was being weird so i just redid the condition of if it's e or E it breaks the loop
                break;
            } else {
                // if the answer is not Y/y/E/e i say sorry and rescan the answer
                System.out.println(
                        "Sorry, I couldn't understand that. Please enter y/Y for yes or e/E to Exit program.");
                ans = input.next();
            }
        }

        // print goodbye and end the program
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public static void editNames(Names namesList) {
        // scan the name
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name you would like to change:");
        String name = input.nextLine();
        // turn the input into the format of the arraylist
        String formattedName = name.trim().toUpperCase();

        // if the name after being trimmed and turned into uppercase is not in the array list, then
        if (!namesList.findName(formattedName)) {
            // i tell the user i didnt find the name and ask if they want to add it to the list
            System.out.println("Sorry no such name in your list. Would you like to add " + name
                    + " to the list? enter y/Y for yes or n/N for no :");
            // scan the answer
            String ans = input.nextLine();
            // if they say yes...
            if (ans.equals("Y") || ans.equals("y")) {
                // first i check if the array is not already full
                if (namesList.getSize() == 5) {
                    // if it is already 5, i say sorry and restart the loop 
                    System.out.println("Sorry, you can't add a new name as you already have 5 names!");
                    loopChangeNames(namesList);
                } else {
                    // but then if it is not full, i add the name to the list,
                    namesList.add(formattedName);
                    // print the new array list,
                    System.out.println(formattedName + " added to the list. Here is your new list:");
                    System.out.println(namesList.toString());
                    // and restart the loop
                    loopChangeNames(namesList);
                }
            } else {
                // if the user doesn't want to add, i restart the editing part only, not the entire loop bc it would be annoying
                editNames(namesList);
            }
        } else {
            // if the name it's in the array list...
            // ask the user to enter the new name
            System.out.println("Enter the new name:");
            String newName = input.nextLine();
            // edit the name in the arraylist with a method from the class
            namesList.editName(formattedName, newName.trim().toUpperCase());
            // p´rint the new arraylist
            System.out.println("Got it! Here is the new list:");
            System.out.println(namesList.toString());
            // restart the loop
            loopChangeNames(namesList);
        }
    }
}

// all methods only concern and manipulate the list, there are no prompts here, that's up to the Homework4
class Names {
    // private list
    private ArrayList<String> list;

    // getters and setters
    public ArrayList<String> getList() {
        return this.list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    // default constructor that just creates and new arraylist
    public Names() {
        list = new ArrayList<String>();
    }

    // method to return the size of the arraylist
    public int getSize() {
        return list.size();
    }

    // method to add a name to the arraylist
    public void add(String name) {
        list.add(name);
    }

    // method that receives a name and search the arraylist to see if the received name is in the arraylist
    public boolean findName(String name) {
        boolean found = false;
        for (String n : list) {
            // if the name is in the array list it returns true, if it isnt, returns false
            if (n.equals(name)) {
                found = true;
            }
        }

        return found;

    }

    // method that receives a name inside the arraylist and a new name and sets the name as the new name
    public void editName(String name, String newName) {
        // get the index of the name
        int index = list.indexOf(name);

        // "edit" it by using the index and the new name
        list.set(index, newName);
    }

    // method that turns the arraylist into a string
    public String toString() {
        String all = "";

        // sorting it alphabetically
        Collections.sort(list);

        // creating the string
        for (String n : list) {
            if (n != null) {
                all = all + n + ",";
            }
        }

        // printing it in the format "[NAME,NAME,NAME]", the regex will remove the last comma
        return "[" + all.replaceAll("\\,+$", "") + "]";
    }
}
