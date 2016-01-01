package pl.promity.patterns.dynamicfactory.abstractclass;

import org.junit.Before;
import org.junit.Test;
import pl.promity.patterns.common.Product;

import static org.assertj.core.api.Assertions.*;

public class ProductDynamicFactoryTest {

    private ProductDynamicFactory objectUnderTest;

    @Before
    public void setUp() throws Exception {
        objectUnderTest = new ProductDynamicFactory();
    }

    @Test
    public void testRegisteringAndCreatingNewProduct() throws Exception {
        //given
        TestProduct expectedProduct = new TestProduct();
        String key = "key";

        //when
        objectUnderTest.registerNewProductClass(key, TestProduct.class);

        //then
        Product resultProduct = objectUnderTest.createProduct(key);
        assertThat(resultProduct).isNotNull().isEqualTo(expectedProduct);
    }

}