import java.util.LinkedList;

public class Company3 {
    private LinkedList<Employee> list;

    public LinkedList<Employee> getList() {
        return this.list;
    }

    public void setList(LinkedList<Employee> list) {
        this.list = list;
    }

    public Company3() {
        list = new LinkedList<Employee>();
    }

    public void add(Employee e) {
        list.add(e);
    }

    public void fire(Employee e) {
        list.remove(e);
    }

    public boolean fireByNum(int num) {
        for(Employee e : list) {
            if(e.getNum() == num) {
                fire(e);
                return true;
            }
        }

        return false;
    }
 
    public String toString() {
        String all = "";
        for(Employee e : list) {
            if(e != null)
                all = all + e + "\n";

        }
        return all;
    }
}
