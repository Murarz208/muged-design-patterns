package pl.promity.patterns.common.animals;

public class Elephant implements Animal, Mammal {

    @Override
    public void introduceYourself() {
        System.out.println("Hi, I'm elephant");
    }
}
