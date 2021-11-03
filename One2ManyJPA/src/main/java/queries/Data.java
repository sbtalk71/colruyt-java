package queries;

public class Data {
    private String name;
    private double salary;

    public Data(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
