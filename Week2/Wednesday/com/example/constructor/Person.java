package Day3.com.example.constructor;

public class Person {

    private String name;
    private int age;


    public Person(){
        this.name = "Placeholder";
        this.age = 18;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    public String displayPerson(){
        return  "I'm "+ this.name + " and i'm " + this.age + " years old.";
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}
