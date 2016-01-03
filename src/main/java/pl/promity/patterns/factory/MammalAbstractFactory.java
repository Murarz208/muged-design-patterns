package pl.promity.patterns.factory;

import pl.promity.patterns.common.animals.Animal;
import pl.promity.patterns.common.animals.Cat;
import pl.promity.patterns.common.animals.Elephant;

public class MammalAbstractFactory implements AnimalAbstractFactory{

    @Override
    public Animal createSmallAnimal() {
        return new Cat();
    }

    @Override
    public Animal createBigAnimal() {
        return new Elephant();
    }

}
