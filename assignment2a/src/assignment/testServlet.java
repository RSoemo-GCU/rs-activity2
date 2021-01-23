package assignment;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("=======> This is the init!");
	}

	/**
	 * @see Servlet#destroy()
	 */
    @Override
	public void destroy() {
		System.out.println("=======> This is destroy!");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty())
		{
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("firstname", firstName);
			request.setAttribute("lastname", lastName);
			request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		}
		
		
		//response.getWriter().append("Hello my name is: ").append(firstname + " " + lastname);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
