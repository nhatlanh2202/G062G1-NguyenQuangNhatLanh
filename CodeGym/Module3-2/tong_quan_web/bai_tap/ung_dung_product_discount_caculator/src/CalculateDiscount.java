import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateDiscount", urlPatterns = "/discount")
public class CalculateDiscount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Description = request.getParameter("Description");
        float Price = Float.parseFloat(request.getParameter("Price"));
        float Discount = Float.parseFloat(request.getParameter("Discount"));
        float DiscountPrice = (float) (Price * Discount * 0.01);
        float Amount = Price - DiscountPrice;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Description: " + Description+ "</h1>");
        writer.println("<h1>Price: " + Price+ "</h1>");
        writer.println("<h1>Discount: " + Discount+ "%</h1>");
        writer.println("<h1>Amount: " + Amount+ "</h1>");
        writer.println("<h1>Discount Price: " + DiscountPrice + "</h1>");
        writer.println("</html>");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
