public class AppArrayList {
    public static void main(String[] args) {
        Company2 dunderMifflin = new Company2();

        dunderMifflin.add(new Employee("Michael Scott", 111));
        dunderMifflin.add(new Employee("Jim Halpert", 222));
        dunderMifflin.add(new Employee("Dwight Schrute", 333));

        dunderMifflin.fire(new Employee("Michael Scott", 111));

        System.out.println(dunderMifflin.getList());
        System.out.println(dunderMifflin);
    }
}
