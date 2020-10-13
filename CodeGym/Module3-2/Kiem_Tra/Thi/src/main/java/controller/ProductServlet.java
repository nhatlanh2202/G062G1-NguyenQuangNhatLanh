package controller;

import bo.ProductBO;
import bo.ProductBOImpl;
import model.Category;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    ProductBO productBO = new ProductBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionProduct = request.getParameter("actionProduct");
        if (actionProduct == null) {
            actionProduct = "";
        }
        switch (actionProduct) {
            case "createNewProduct":
                createNewProduct(request, response);
                break;
            case "updateProduct":
                updateProduct(request, response);
                break;
            case "searchProduct":
                searchProduct(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionProduct = request.getParameter("actionProduct");
        if (actionProduct == null) {
            actionProduct = "";
        }
        switch (actionProduct) {
            case "showCreateNewProduct":
                showCreateNewProduct(request, response);
                break;
            case "showEditProduct":
                showEditProduct(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    private void showCreateNewProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = this.productBO.findAllCategory();
        request.setAttribute("categoryList", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create-new-product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.productBO.findAllProduct();
        List<Category> categoryList = this.productBO.findAllCategory();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list-product.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/demo.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private Product informationProduct(HttpServletRequest request) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String category = request.getParameter("category");

        return new Product(name, price, quantity, color, category);
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
        Product product = informationProduct(request);

        String message = this.productBO.save(product);
        request.setAttribute("message", message);
        if (!message.equals("Create Complete !")) {
            request.setAttribute("product", product);
        }
        showCreateNewProduct(request, response);
        //listProduct(request, response);
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = this.productBO.findByID(id);
        request.setAttribute("product", product);

        List<Category> categoryList = this.productBO.findAllCategory();
        request.setAttribute("categoryList", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit-product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        Product product = informationProduct(request);
        String id = request.getParameter("id");
        product.setId(id);

        String message = this.productBO.update(product);
        request.setAttribute("message", message);
        if (!message.equals("Update Complete !")) {
            request.setAttribute("product", product);
        }
        listProduct(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        this.productBO.delete(id);
        listProduct(request, response);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameProduct");
        List<Product> productList = this.productBO.findByName(name);
        request.setAttribute("productList", productList);
        List<Category> categoryList = this.productBO.findAllCategory();
        request.setAttribute("categoryList", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/search-product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
