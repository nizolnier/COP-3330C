/* Nicole Zolnier - 04/21/2022
Homework 5
*/
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Homework6 {
	public static void main(String[] args) throws Exception {
		//  create linked list
		LinkedList list = new LinkedList();

		loopMenuChoices(list);

	}

	public static String stringInput(String prompt) {
		System.out.println(prompt);
		return new Scanner(System.in).nextLine();
	}

	public static int intInput(String prompt) {
		System.out.println(prompt);

		int inp;
		// here is to avoid that the user doesn't enter an integer
		// it scans the line and tries to convert it into an int
		// if that fails, it is going to print a message and redo the scan
		while (true) {
			try {
				String input = new Scanner(System.in).nextLine();
				inp = Integer.parseInt(input);

				break;
			} catch (Exception e) {
				System.out.println("Please enter an integer.");
			}
		}

		return inp;

	}

	public static double doubleInput(String prompt) {
		System.out.println(prompt);

		double inp;
		// here is to avoid that the user doesn't enter an integer
		// it scans the line and tries to convert it into an int
		// if that fails, it is going to print a message and redo the scan
		while (true) {
			try {
				String input = new Scanner(System.in).nextLine();
				inp = Double.parseDouble(input);

				break;
			} catch (Exception e) {
				System.out.println("Please enter a number.");
			}
		}

		return inp;

	}

	public static String choiceInput() {
		System.out.println("\tEnter your selection: ");
		return new Scanner(System.in).nextLine();
	}

	public static void displayMenu() {
		System.out.println("___________Choose one of the options____________________");
		System.out.println("1. Print all the employees");
		System.out.println("2. Add a new employee");
		System.out.println("3. Search for an employee");
		System.out.println("4. Find the highest net salary");
		System.out.println("5. Delete an employee");
		System.out.println("6. Exit Program");
	}

	public static void loopMenuChoices(LinkedList list) {
		String ans;
		// using a do while to do everything at least once
		// while the answer is not 6
		do {
			// print the menu and get the choice from user
			displayMenu();
			ans = choiceInput();
			// analyze each case, if it doesnt match any, it is just gonna do it again
			if (ans.equals("1")) {
				printEmployees(list);
			} else if (ans.equals("2")) {
				addEmployee(list);
			} else if (ans.equals("3")) {
				searchByName(list);
			} else if (ans.equals("4")) {
				findHighestNetSalary(list);
			} else if (ans.equals("5")) {
				deleteEmployee(list);
			} else if (ans.equals("6")) {
				break;
			}

		} while (!ans.equals("6"));
	}

	public static void printEmployees(LinkedList list) {
		// call print method
		list.print();
	}

	public static void addEmployee(LinkedList list) {
		String name = stringInput("Enter employee name: ");
		double salary = doubleInput("Enter salary: ");
		int numberOfDependents = intInput("Enter number of dependents: ");

		Employee e = new Employee(name.trim(), salary, numberOfDependents);
		list.add(e);
	}

	public static void searchByName(LinkedList list) {
		// ask for the name of the employee
		String name = stringInput("Enter employee name: ");
		// if the name is in the list, it prints found, if not it prints not found
		if (list.get(name)) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
	}

	public static void findHighestNetSalary(LinkedList list) {
		// call getHighest if it doesnt return -1 and print it
		if(list.getHighest() != -1) {
			System.out.println("The highest net salary is " + list.getHighest());
		} else {
			System.out.println("There is no highest net salary");
		}
		

	}

	public static void deleteEmployee(LinkedList list) {
		// ask for the name of the employee
		String name = stringInput("Enter employee name: ");
		// call remove
		list.remove(name);
	}
}

class LinkedList {

	private Node list;
	private int size;
	// ___________________________________

	public LinkedList() {
		list = null;
		size = 0;
	}

	public void clear() {
		list = null;
		size = 0;
	}

	// print method
	public void print() {
		Node temp = list;

		// while the list still has nodes, print the data
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;

		}
		System.out.println("null");
	}

	public double getHighest() {
		Node temp = list;
		double max = 0;

		// if the list is null 
		if (list == null)
			return -1;
		while (temp != null) {
			// if the temp net salary is higher than the max, then this is new max
			if (max < temp.data.getNetSalary())
				max = temp.data.getNetSalary();
			temp = temp.next;
		}

		return max;
	}

	public void add(Employee data) {
		// if the list is null, the data will be the head 
		if (list == null) {
			list = new Node();
			list.next = null;
			list.data = data;
			++size;
			return;
		}
		Node temp = list;

		// search the list for a null place
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node();
		temp.next.data = data;
		temp.next.next = null;
		++size;
	}

	public void remove(String name) {
		// if the list is null, there's nothing we can do
		if (list == null)
			return;

		// if the head is the employee to be deleted, then set it to be the next employee
		if (list.data.getName().equalsIgnoreCase(name)) {
			list = list.next;
			size--;
			return;
		}

		Node temp = list;

		// search the array
		// if one of the conditions is true, the loop breaks and i analyze temp
		while (temp.next != null && !temp.next.data.getName().equalsIgnoreCase(name)) {
			temp = temp.next;
		}

		// if temp is null, there's nothing to do
		if (temp.next == null) {
			return;
		}

		// if temp is the employee then set it to the next employee
		if (temp.next.data.getName().equalsIgnoreCase(name)) {
			temp.next = temp.next.next;
			size--;
		}

	}
	
	// similar logic to remove, but here i just return true or false instead of deleting it
	public boolean get(String name) {
		if (list == null)
			return false;

		if (list.data.getName().equalsIgnoreCase(name)) {
			return true;
		}

		Node temp = list;

		while (temp.next != null && !temp.next.data.getName().equalsIgnoreCase(name)) {
			temp = temp.next;
		}

		if (temp.next == null) {
			return false;
		}

		if (temp.next.data.getName().equalsIgnoreCase(name)) {
			return true;
		}

		return false;
	}

}

class Employee {
	// private attributes
	private int id;
	private String name;
	private double salary;
	private int numberOfDependents;

	// setters and getters
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumberOfDependents() {
		return this.numberOfDependents;
	}

	public void setNumberOfDependents(int numberOfDependents) {
		this.numberOfDependents = numberOfDependents;
	}

	// method to get the net salary
	// this will keep updated if the salary/number of dependents changes
	public double getNetSalary() {
		// using formula provided
		double netSalary = salary * 0.91 + (numberOfDependents * 0.01 * salary);

		// little trick to make the netSalary be rounded to 2 decimal places
		// i used BigDecimal bc i was having some trouble with string.format
		return new BigDecimal(netSalary).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	// overriding the equals method
	// the objects are only equal if they have the same net salary
	public boolean equals(Object obj) {
		return this.getNetSalary() == ((Employee) obj).getNetSalary();
	}

	// overriding the toString method to print the name
	public String toString() {
		return name;
	}

	// constructor
	public Employee(String name, double salary, int numberOfDependents) {
		int id = 0;
		this.name = name;
		this.salary = salary;
		this.numberOfDependents = numberOfDependents;

		// to set the id as the sum of the ascii codes, i convert the name into an array of chars
		// then add each char to the id
		for (char c : name.toLowerCase().toCharArray()) {
			id += c;
		}

		// and set the new id
		this.id = id;
	}

}

class Node {
	public Employee data;
	Node next;
	Node below;
}