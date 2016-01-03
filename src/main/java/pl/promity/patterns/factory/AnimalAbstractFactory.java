package pl.promity.patterns.factory;

import pl.promity.patterns.common.animals.Animal;

/**
 * Simple example for abstract factory design pattern
 */
public interface AnimalAbstractFactory {

    Animal createSmallAnimal();

    Animal createBigAnimal();

}
