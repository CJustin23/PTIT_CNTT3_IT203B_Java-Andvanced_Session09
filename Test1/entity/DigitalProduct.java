package Test1.entity;
public class DigitalProduct extends Product {
    private double size;

    public DigitalProduct(String id, String name, double price, double size) {
        super(id, name, price);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Digital] ID: " + id + " | Tên: " + name + " | Giá: " + price + " | Dung lượng: " + size + " MB");
    }
}