import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet051")
public class Servlet_05_1 extends HttpServlet {
    List<Items> basket = new ArrayList<Items>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.getWriter().append(generateForm());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));

        HttpSession httpSession = req.getSession();
       //pobieranie atrybutu

        if (httpSession.getAttribute("basket")!=null) {
            basket = (ArrayList<Items>) httpSession.getAttribute("basket");
        }
        Items item1 = new Items(name,quantity,price);
        //dodawanie do listy
        basket.add(item1);
        //zapisywanie atrybutu do sesji
        httpSession.setAttribute("basket",basket);
//        List<Items> test = (List<Items> ) httpSession.getAttribute("basket");

        //        httpSession.setAttribute("basket", new Items(name,quantity,price));


//        basket.add((Items) httpSession.getAttribute("basket"));

        for (Items items : basket) {
            resp.getWriter().println(items.name);
        }
        resp.getWriter().println("---------------------");


    }

    private String generateForm() {
        String form = "<html>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"/servlet051\">\n" +
                "        <div>\n" +
                "            <label for=\"name\">Name</label>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\"/>\n" +
                "        </div>\n" +
                "\n" +
                "        <div>\n" +
                "            <label for=\"quantity\">Quantity</label>\n" +
                "            <input type=\"number\" id=\"quantity\" name=\"quantity\"/>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label for=\"price\">Price</label>\n" +
                "            <input type=\"number\" id=\"price\" name=\"price\" min=\"0\" step=\"0.01\"/>\n" +
                "        </div>\n" +
                "    <button type=\"submit\">add to basket</button>\n" +
                "    <a href=\"servlet052\">zawartość koszyka</a>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n";
        return form;
    }
}
