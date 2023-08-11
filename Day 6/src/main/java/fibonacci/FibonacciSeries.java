package fibonacci;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class FibonacciSeries
 */
public class FibonacciSeries extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public FibonacciSeries() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html");
//		response.getWriter().println("<h1>Hello, World</h1>");
//		response.getWriter().close();
//	}
	public List<Integer> fibo(int n){
		
		List<Integer> fiboSeries = new ArrayList<>();
		int n1 = 0;
		int n2 = 1;
		int n3;
		
		fiboSeries.add(n1);
		fiboSeries.add(n2);
		
		for(int i=2;i<n;i++) {
			
			n3 = n1 + n2;
			fiboSeries.add(n3);
			n1 = n2;
			n2 = n3;
		}
		
		return fiboSeries;
	}
	public int sumOfFibo(List<Integer> list) {
		
		int sum = 0;
		
		for(int i=0;i<list.size();i++) {
			
			sum += list.get(i);
		}
		
		return sum;
	}
	
	  @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp) {
	    try {
	      Map <String, String[]> parameterMap = req.getParameterMap();
	      parameterMap.entrySet().stream().forEach(entry -> {
	        System.out.print("key: " + entry.getKey());
	        System.out.print(" values: " + Arrays.toString(entry.getValue()) + "\n");
	      });
	      PrintWriter out = resp.getWriter();
	      String userName = parameterMap.get("name")[0];
	      int input = Integer.valueOf(userName);
	      List<Integer> ans = new ArrayList<>();
	      ans = fibo(input);
	      int sumFibo = sumOfFibo(ans);
	      out.println(String.format("<h1>Fibonacci Series for the input %s is %s and sum of the series is %s!</h1>",input, ans , sumFibo));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		  
		  PrintWriter out = resp.getWriter();
		  int limit = Integer.valueOf(req.getParameter("formLimit"));
		  List<Integer> ans = new ArrayList<>();
	      ans = fibo(limit);
	      int sumFibo = sumOfFibo(ans);
	      out.println(String.format("<h1>Fibonacci Series for the input %s is %s and sum of the series is %s!</h1>",limit, ans , sumFibo));
	  }

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
