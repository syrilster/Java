package Arrays;

public class Employee {
    private String branch;
    private String name;

    public Employee(String branch, String name) {
        this.branch = branch;
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
