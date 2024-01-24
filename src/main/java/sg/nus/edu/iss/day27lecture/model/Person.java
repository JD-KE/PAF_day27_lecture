package sg.nus.edu.iss.day27lecture.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// refers to NoSql document
@Document(collection = "persons")
public class Person {

    @Id
    private String personId;
    private String name;
    private long age;
    private String gender;
    private List<String> hobbies;
    public Person(String personId, String name, long age, String gender, List<String> hobbies) {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
    }
    public Person(String name, long age, String gender, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
    }
    @Override
    public String toString() {
        return "Person [personId=" + personId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", hobbies="
                + hobbies + "]";
    }
    public Person() {
    }
    public String getPersonId() {
        return personId;
    }
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getAge() {
        return age;
    }
    public void setAge(long age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public List<String> getHobbies() {
        return hobbies;
    }
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    
    
}
