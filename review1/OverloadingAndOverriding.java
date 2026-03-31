class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void age(int years) {
        System.out.println("Dog is " + years + " years old");
    }
    void age(int years, String name) {
        System.out.println("Dog is " + years + " years old");
        System.out.println("Dog's name is " + name);
    }
}
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
public class OverloadingAndOverriding {
    public static void main(String[] args) {
        System.out.println("Demonstrating Method Overloading and Overriding");
        Animal dog = new Dog();
        Animal cat = new Cat();
        System.out.println("Method overriding");
        // overriding
        dog.sound();
        cat.sound();
        // overloading
        System.out.println("Method overloading on Dog class");
        Dog d = new Dog();
        d.age(5);
        d.age(3, "sheru");
        
    }
}
