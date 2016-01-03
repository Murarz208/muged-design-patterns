package pl.promity.patterns.factory;

import pl.promity.patterns.common.animals.Animal;
import pl.promity.patterns.common.animals.Sardine;
import pl.promity.patterns.common.animals.Shark;

public class FishAbstractFactory implements AnimalAbstractFactory{

    @Override
    public Animal createSmallAnimal() {
        return new Sardine();
    }

    @Override
    public Animal createBigAnimal() {
        return new Shark();
    }

}
