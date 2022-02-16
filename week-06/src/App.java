public class App {
    public static void main(String[] args) {
        Company dunderMifflin = new Company();

       Employee[] someList = {
           new Employee("Michael Scott", 111),
           new Employee("Jim Halpert", 222),
           new Employee("Dwight Schrute", 333)
       }; 

       /* for (Employee e : someList) {
           System.out.println(e);
       } */

       System.out.println("Before adding .....");
       dunderMifflin.setList(someList);
       System.out.println(dunderMifflin);

       
       System.out.println("After adding .....");
       dunderMifflin.add(new Employee("Pam Beesly", 444));
       System.out.println(dunderMifflin);


    }
}

