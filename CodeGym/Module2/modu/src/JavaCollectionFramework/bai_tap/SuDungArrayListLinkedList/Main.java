package JavaCollectionFramework.bai_tap.SuDungArrayListLinkedList;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        Product product1 = new Product(1,"BMW",5000);
        Product product2 = new Product(2,"Audi",5500);
        Product product3 = new Product(3,"Rolls Royce",7500);
        Product product4 = new Product(4,"VinFast",3500);

        productManager.arrayList.add(product1);
        productManager.arrayList.add(product2);
        productManager.arrayList.add(product3);
        productManager.arrayList.add(product4);

        productManager.displayProducts();
        productManager.remove(4);
        System.out.println("--------------------");
        System.out.println("Xóa sản phẩm có id = 2");
        productManager.displayProducts();
        System.out.println("---------------------");
        System.out.println("Find Audi");
        productManager.find("Audi");
        System.out.println("---------------------");
        System.out.println("Giá tăng dần của sản phẩm: ");
        productManager.ascendingPrice();
        productManager.displayProducts();
        System.out.println("---------------------");
        System.out.println("Giá giảm dần của sản phẩm");
        productManager.decendingPrice();
        productManager.displayProducts();

    }
}
