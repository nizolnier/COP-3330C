public class Company {
    private Employee[] list;
    private final int SIZE = 100;

    public void setList(Employee[] list) {
        this.list = new Employee[SIZE];
        for (int i = 0; i < SIZE; i++)
            this.list[i] = null;

        if( list.length > SIZE) return;
        
        for(Employee e : list)
            this.add(e);
    }

    public Employee[] getList() {
        return this.list;
    }

    public Company() {
        list = new Employee[SIZE];
        for (int i = 0; i < SIZE; i++)
            list[i] = null;
    }
   

    public Company(Employee[] list) {
        setList(list);
    }

    public String toString() {
        String all = "";
        for(Employee e : list) {
            if(e != null)
                all = all + e + "\n";

        }
        return all;
    }

    public boolean add(Employee e) {
        int index = 0;
        while(index < SIZE) {
            if(list[index] == null) break;
            index++;
        }

        if(index >= SIZE) return false;

        list[index] = e;
        return true;
    }

    public boolean fire(int num) {
        int i;
        for(i = 0; i < SIZE; i++) {
            if(list[i] != null) {
                if(list[i].getNum() == num) {
                    list[i] = null;
                    return true;
                }
                    
            }
        }

        return false;
    }
}