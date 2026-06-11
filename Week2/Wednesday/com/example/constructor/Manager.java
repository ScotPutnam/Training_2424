package Day3.com.example.constructor;

public class Manager {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Scot");
        person.setAge(24);
        
        System.out.println(person.displayPerson());
    }
    
}
