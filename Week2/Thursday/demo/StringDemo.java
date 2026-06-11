package Week2.Thursday.demo;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = new String("Hey");

        String s11 = s1.concat(" Scot");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 + " " + s2 + " " + s11);

        
        s1.equalsIgnoreCase(s2); 
        s1.toUpperCase();
        s1.trim();
        s1.replace("e", "a");
        s1.contains("11");
        
        // String buffer and String builder - mutable string objects
        // String buffer is thread safe - use in multi-threading enviroments
        // String builder is not thread safe - use everywhere else

        StringBuffer sBuffer = new StringBuffer("Hello");
        sBuffer.append(1);
        System.out.println(sBuffer);
        sBuffer.insert(2, "Woohoo");
        System.out.println(sBuffer);
        sBuffer.replace(0, 5, "Hello");
        System.out.println(sBuffer);

    }
}
