
package model;

public class Employee {
    
    private  int id;
    private  String name;
    private  String dejignation;
    private  float salary;

    public Employee() {
    }

    public Employee(int id, String name, String dejignation, float salary) {
        this.id = id;
        this.name = name;
        this.dejignation = dejignation;
        this.salary = salary;
    }

    public Employee(String name, String dejignation, float salary) {
        this.name = name;
        this.dejignation = dejignation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDejignation() {
        return dejignation;
    }

    public void setDejignation(String dejignation) {
        this.dejignation = dejignation;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

   

   
    
    
}
