

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getServletPath();
		switch(action)
		{
		case "/": home(request,response);
		            break; 
		case "/add":add(request,response);
                    break; 
		case "/edit":edit(request,response);
                    break;             
		case "/update":update(request,response);
                    break;  
		case "/delete":delete(request,response);
                        break;                
		default: home(request,response);
                      break;            
		}
	}



	private void edit(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		employee e=Dao.getById(id);
		try {
			request.setAttribute("emp", e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Edit.jsp");
		   	dispatcher.forward(request, response);
			
		} catch (IOException | ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		
		int id =Integer.parseInt(request.getParameter("id"));
		Dao.delete(id);
        home(request,response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		
		//update code here
	
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		
	   try {
		response.sendRedirect("Insert.jsp");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	private void home(HttpServletRequest request, HttpServletResponse response) {
		
		 try {
			 List<employee> list=Dao.getAll(); 
			 request.setAttribute("list", list);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		   	dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
