package table;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private Float due;
    private String website;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, float due, String website) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.due = due;
        this.website = website;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    public String getFullName(){
        return this.firstName + this.lastName;
    }
}
