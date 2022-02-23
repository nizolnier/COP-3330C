import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        /* Employee e = new Employee("Jim");
        System.out.println(e);

        Salaried s = new Salaried("Erika", 2.3);

        System.out.println(s);
        s.printCheck();

        Employee ee = new Salaried("Eri", 2.3);
        System.out.println(((Salaried) ee).getSalary()); */

        ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new HourlyPaid("Ericka Jones", 120));
		
		list.add(new Manager("Karim DuPont", 12.3, 15));
		
		list.add(new Salaried("Ericka Jones", 120));

		printCheck(list.get(0));
    }

    private static void printCheck ( Employee e) {
		e.printCheck();
		
		if ( e instanceof Manager) 
			System.out.println(((Manager)e).getBonus());
	}
}

//________________________________________
final class Manager extends Salaried{
	private double bonus;
	
	public Manager() {
		super();
		bonus = 0;
		
	}
	
	public Manager (String name, double salary , double bonus) {
		super(name, salary);
		this.bonus = bonus;
	}
	
	public String toString() {
		return super.toString() + " Bonus:" + bonus;
	}
	
	public void printCheck() {
		super.printCheck();
		System.out.println("Bonus is: "+bonus);
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
}

//________________________________________
class HourlyPaid extends Employee{
	private int hoursWorked;
	
	public HourlyPaid(String name, int hoursWorked) {
		super(name);
		this.hoursWorked = hoursWorked;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	@Override
	public String toString() {
		return "HOURLY >> "+super.toString() + " " + hoursWorked;
	}
	
	public void printCheck() {
		System.out.println("++++++++++++++\n"+toString());
		
	}
	
}
//________________________________________
// child/sub class
class Salaried extends Employee {
    private double salary;

    public Salaried() {
        super();
        salary = 0.0;
    }

    public Salaried(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public Salaried(String name) {
        super(name);
    }

    public double getSalary() {
        return this.salary;
    }

    public String toString() {
        return super.toString() + " " + salary;
    }

    public void printCheck() {
        System.out.println("_____\n" + toString());
    }
}

//_________________________________________
// super class
// abstract class Employee - cannot create object, only reference
abstract class Employee {
	private String name;
	
	abstract public void printCheck();
	
	public double getSalary() {
		return 0.0;
	}
	public String toString () {
		return name;
	}
	public Employee() {
		this.name = "";
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
