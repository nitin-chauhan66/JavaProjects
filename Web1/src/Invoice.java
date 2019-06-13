

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Invoice")
public class Invoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Invoice() {
        super();
    }
    private int Price(String item) {
    	int price=0;
    	if(item.equals("nike")) {
    		price=5000;
    		}
    	else if(item.equals("mobile")){
    		price=16000;
    	}
    	else if(item.equals("laptop")){
    		price=60000;
    	}
    	else if(item.equals("trimer")){
    		price=1200;
    	}
    	return price;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String items[] = request.getParameterValues("items");
		HttpSession s1 = request.getSession(false);
		String Uname =( String )s1.getAttribute("Uname");
		out.println(Uname+" Your Order summery ");
		int tprice = 0;
		s1.setAttribute("product",items);
		
		
			String[] sr = (String[])s1.getAttribute("product");
			
			for(int i=0;i<sr.length;i++) {
				out.println("Item Name :"+sr[i]+" Price : "+Price(sr[i]));
				tprice=tprice+Price(sr[i]);   
			}
		out.println(" Amount Payable : "+tprice);
	}

}
