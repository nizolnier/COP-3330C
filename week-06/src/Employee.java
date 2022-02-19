public class Employee {
    private String name;
    private int num;

    public Employee(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String toString() {
        return "name: " + name + ", num: " + num; 
    }
}
