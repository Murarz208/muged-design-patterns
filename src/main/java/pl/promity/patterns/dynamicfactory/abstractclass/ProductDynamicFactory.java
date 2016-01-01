package pl.promity.patterns.dynamicfactory.abstractclass;

import com.google.common.base.Preconditions;
import pl.promity.patterns.common.Product;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Dynamic factory example for registering class objects
 */
public class ProductDynamicFactory {

    private final ConcurrentHashMap<String, Class<? extends Product> > productsClassRegistry;

    public ProductDynamicFactory() {
        productsClassRegistry = new ConcurrentHashMap<>();
    }

    /**
     * Register product class to factory. You cannot overwrite key with different product classes.
     * Product class shouldn't be abstract class or interface and must have non argument constructor.
     * @param key Product key, which will be used for distinguishing products
     * @param productClass To know which class should be created for given key
     * @throws NullPointerException when any of arguments is null
     */
    public void registerNewProductClass(String key, Class<? extends Product> productClass){
        Preconditions.checkNotNull(key, "trying to register product with null key");
        Preconditions.checkNotNull(productClass, "trying to register product with null class");
        productsClassRegistry.putIfAbsent(key, productClass);
    }

    /**
     * Creates new product instance for given key
     * @param key Key associated with proper {@link Product} instance, must be non null
     * @return NullPointerException when given key is null
     * @throws IllegalAccessException {@link Class#newInstance()}
     * @throws InstantiationException {@link Class#newInstance()}
     * @throws IllegalArgumentException when there are no products associated with given key
     */
    public Product createProduct(String key) throws IllegalAccessException, InstantiationException, IllegalArgumentException {
        Preconditions.checkNotNull(key, "trying to create product with null key");
        Optional<? extends Class<? extends Product>> productClass = Optional.ofNullable( productsClassRegistry.get(key) );
        if(productClass.isPresent()){
            return productClass.get().newInstance();
        }
        else{
            throw new IllegalArgumentException("can't find any product class for given key " + key);
        }
    }

}
