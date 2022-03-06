package HashCodeAndEquals;

public class MAin {

    public static void main(String[] args) {
        Student s1 = new Student("Vishal", 1);
        Student s2 = new Student("Vishal",1);

        System.out.println(s1.equals(s2)); //simply == comparison in object class

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());


    }
}
