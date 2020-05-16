package pl.coderslab.collection;

public class Person {
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;

    public Person(String  email, String firstName, String lastName, Integer age, String city) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "email='"+ email + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
