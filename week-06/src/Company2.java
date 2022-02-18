import java.util.ArrayList;

public class Company2 {
    private ArrayList<Employee> list;

    public ArrayList<Employee> getList() {
        return this.list;
    }

    public void setList(ArrayList<Employee> list) {
        this.list = list;
    }

    public Company2() {
        list = new ArrayList<Employee>();
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
