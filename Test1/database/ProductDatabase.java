package Test1.database;
import Test1.entity.DigitalProduct;
import Test1.entity.PhysicalProduct;
import Test1.entity.Product;
import java.util.ArrayList;
import java.util.List;
public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products = new ArrayList<>();
    private ProductDatabase() {}
    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Add done");
    }
    public List<Product> getProducts() {
        return products;
    }
    public boolean updateProduct(String id, String newName, double newPrice, double newExtra) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                p.setName(newName);
                p.setPrice(newPrice);
                if (p instanceof PhysicalProduct) {
                    ((PhysicalProduct) p).setWeight(newExtra);
                } else if (p instanceof DigitalProduct) {
                    ((DigitalProduct) p).setSize(newExtra);
                }
                System.out.println("Update done");
                return true;
            }
        }
        System.out.println("Ko thấy id: " + id);
        return false;
    }

    public boolean deleteProduct(String id) {
        boolean removed = products.removeIf(p -> p.getId().equals(id));
        if (removed) {
            System.out.println("Done");
        } else {
            System.out.println("Ko thấy id : " + id);
        }
        return removed;
    }
}