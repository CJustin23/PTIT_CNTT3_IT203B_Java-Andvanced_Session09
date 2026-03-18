package Test1.factory;
import Test1.entity.DigitalProduct;
import Test1.entity.PhysicalProduct;
import Test1.entity.Product;
public class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price, double extra) {
        if (type == 1) {
            return new PhysicalProduct(id, name, price, extra);
        } else if (type == 2) {
            return new DigitalProduct(id, name, price, extra);
        } else {
            throw new IllegalArgumentException("không đúng");
        }
    }
}