package pl.promity.patterns.common.animals;

public class Cat implements Animal, Mammal {

    @Override
    public void introduceYourself() {
        System.out.println("Hi, I'm cat");
    }
}
