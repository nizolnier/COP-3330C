public class AppLinkedList {
    public static void main(String[] args) {
        Company3 dunderMifflin = new Company3();

        dunderMifflin.add(new Employee("Michael Scott", 111));
        dunderMifflin.add(new Employee("Jim Halpert", 222));
        dunderMifflin.add(new Employee("Dwight Schrute", 333));

        dunderMifflin.fire(new Employee("Michael Scott", 111));

        System.out.println(dunderMifflin.getList());

        dunderMifflin.fireByNum(111);
        
        System.out.println(dunderMifflin);

    }
}
