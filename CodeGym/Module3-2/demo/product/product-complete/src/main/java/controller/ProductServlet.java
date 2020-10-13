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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
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
            case "showDetailProduct":
                showDetailProduct(request, response);
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

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private Product informationProduct(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        return new Product(id, name, price, quantity, color, description, category);
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
        Product product = informationProduct(request);

        String message = this.productBO.save(product);

        if (!message.equals("Create Complete !")) {
            request.setAttribute("product", product);

            String[] messages = message.split(",");
            for (String element : messages) {
                if (element.contains("ID")) {
                    request.setAttribute("messageID", element);
                }
                if (element.contains("price")) {
                    request.setAttribute("messagePrice", element);
                }
                if (element.contains("quantity")) {
                    request.setAttribute("messageQuantity", element);
                }
            }
        } else {
            request.setAttribute("messageComplete", message);
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

        String message = this.productBO.update(product);

        if (!message.equals("Update Complete !")) {

            String[] messages = message.split(",");
            for (String element : messages) {
                if (element.contains("price")) {
                    request.setAttribute("messagePrice", element);
                }
                if (element.contains("quantity")) {
                    request.setAttribute("messageQuantity", element);
                }
            }

            List<Category> categoryList = this.productBO.findAllCategory();
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("product", product);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit-product.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("messageComplete", message);
            listProduct(request, response);
        }
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

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = this.productBO.findByID(id);
        request.setAttribute("product", product);

        List<Category> categoryList = this.productBO.findAllCategory();
        request.setAttribute("categoryList", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view-detail-product.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
