package model;

public class Student {

    private int id;
    private String name;
    private String email;

    // Empty constructor
    public Student() {

    }

    // Parameterized constructor
    public Student(
            int id,
            String name,
            String email) {

        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(
            String name) {

        this.name = name;
    }

    public void setEmail(
            String email) {

        this.email = email;
    }

}