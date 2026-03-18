package Test1;
import Test1.database.ProductDatabase;
import Test1.entity.Product;
import Test1.factory.ProductFactory;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();
        int choice;
        do {
            System.out.println("----------------------QUẢN LÝ SẢN PHẨM----------------------");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("----------------------------------------------------------");
            System.out.print("Lựa chọn của bạn:\n");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Vui long nhap so!");
                choice = 0;
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Loại sản phẩm:");
                    System.out.println("(1 - Physical )");
                    System.out.println("(2 - Digital  ) ");
                    int type;
                    try {
                        type = Integer.parseInt(sc.nextLine().trim());
                    } catch (Exception e) {
                        System.out.println("Sai");
                        break;
                    }
                    System.out.print("ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Tên: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Giá: ");
                    double price;
                    try {
                        price = Double.parseDouble(sc.nextLine().trim());
                    } catch (Exception e) {
                        System.out.println("Sai");
                        break;
                    }
                    String extraLabel = (type == 1) ? "Physical Product (kg): " : "Digital Product (MB): ";
                    System.out.print(extraLabel);
                    double extra;
                    try {
                        extra = Double.parseDouble(sc.nextLine().trim());
                    } catch (Exception e) {
                        System.out.println("Sai");
                        break;
                    }
                    try {
                        Product p = ProductFactory.createProduct(type, id, name, price, extra);
                        db.addProduct(p);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    List<Product> list = db.getProducts();
                    if (list.isEmpty()) {
                        System.out.println("Rỗng");
                    } else {
                        for (Product p : list) {
                            p.displayInfo();
                        }
                    }
                    break;
                case 3:
                    System.out.print("ID: ");
                    String idUpdate = sc.nextLine().trim();
                    System.out.print("Tên: ");
                    String nameUpdate = sc.nextLine().trim();
                    System.out.print("Giá: ");
                    double priceUpdate;
                    try {
                        priceUpdate = Double.parseDouble(sc.nextLine().trim());
                    } catch (Exception e) {
                        System.out.println("Giá sai");
                        break;
                    }
                    System.out.print("Giá trị mới: ");
                    double extraUpdate;
                    try {
                        extraUpdate = Double.parseDouble(sc.nextLine().trim());
                    } catch (Exception e) {
                        System.out.println("Sai giá trị");
                        break;
                    }
                    db.updateProduct(idUpdate, nameUpdate, priceUpdate, extraUpdate);
                    break;
                case 4:
                    System.out.print("ID: ");
                    String idDelete = sc.nextLine().trim();
                    db.deleteProduct(idDelete);
                    break;
                case 5:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Chọn lại");
            }
        } while (choice != 5);
        sc.close();
    }
}