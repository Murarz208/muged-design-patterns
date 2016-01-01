package pl.promity.patterns.common;

public abstract class Product {

    protected final long id;
    protected final String name;
    protected final int productSize;

    public Product(long id, String name, int productSize) {
        this.id = id;
        this.name = name;
        this.productSize = productSize;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProductSize() {
        return productSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (productSize != product.productSize) return false;
        return name != null ? name.equals(product.name) : product.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + productSize;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productSize=" + productSize +
                '}';
    }
}
