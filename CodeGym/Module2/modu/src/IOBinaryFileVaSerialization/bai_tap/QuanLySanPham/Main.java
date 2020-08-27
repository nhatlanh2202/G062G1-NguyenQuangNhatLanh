package IOBinaryFileVaSerialization.bai_tap.QuanLySanPham;


public class Main {
    public static void main(String[] args){
            FunctionProduct functionProduct = new FunctionProduct();

            functionProduct.creatObject();

            String path = "D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\IOBinaryFileVaSerialization\\bai_tap\\QuanLySanPham\\file";
            functionProduct.writeToFile(functionProduct.containsObject, path);

            functionProduct.readFromFile(path);

            functionProduct.displayProduct();

            Product searchById = functionProduct.searchProduct(3);

            System.out.println(searchById.toString());
    }
}
