package pl.promity.patterns.factory;

import com.google.common.base.Preconditions;
import pl.promity.patterns.common.animals.*;

import java.util.Optional;

/**
 * Simple example for factory method design pattern
 */
public class AnimalFactoryMethod {

    public Optional<Animal> createAnimal(String name){
        Preconditions.checkNotNull(name, "trying to create animal with null name");
        Preconditions.checkArgument( !name.isEmpty(), "trying to create animal with empty name");
        Animal result = null;
        if("CAT".equals(name)){
            result = new Cat();
        }
        if("ELEPHANT".equals(name)){
            result = new Elephant();
        }
        if("SARDINE".equals(name)){
            result = new Sardine();
        }
        if("SHARK".equals(name)){
            result = new Shark();
        }
        return Optional.ofNullable(result);
    }

}

