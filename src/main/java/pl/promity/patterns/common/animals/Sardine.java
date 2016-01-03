package pl.promity.patterns.common.animals;

public class Sardine implements Animal, Fish {

    @Override
    public void introduceYourself() {
        System.out.println("Hi, I'm sardine");
    }
}
