import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet052")
public class Servlet_05_2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        List<Items> basket = (ArrayList<Items>) httpSession.getAttribute("basket");

        double sum = 0;
        for (Items items : basket) {
            resp.getWriter().println(items.name + " - " + items.quantity + " x " + items.price +
                    "zl = " + (items.quantity*items.price) + "zl");
            sum+= items.quantity * items.price;
        }
        resp.getWriter().println("SUMA: " + sum);
    }
}
