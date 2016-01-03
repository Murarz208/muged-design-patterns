package pl.promity.patterns.common.animals;

public class Shark implements Animal, Fish {

    @Override
    public void introduceYourself() {
        System.out.println("Hi, I'm shark");
    }
}

