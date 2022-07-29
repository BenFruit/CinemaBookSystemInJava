public class Dog extends Animal {
    public void bark(){
        System.out.println("Dog barks");
    }

    @Override
    public void talk() {
        System.out.println("Dog talks");
    }
}
