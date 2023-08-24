package noticesWeb;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;


@WebServlet("/notice")
public class NoticeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	public static final String DB_URL = "jdbc:mysql://localhost:3306/Notices";
 	public static final String DB_USER = "prodapt";
 	public static final String DB_PASS = "gaurav@123";
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	NoticeController nc;

	  @Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    nc = new NoticeController();
	    application = JakartaServletWebApplication.buildApplication(getServletContext());
	    final WebApplicationTemplateResolver templateResolver = 
	    new WebApplicationTemplateResolver(application);
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	  }

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    final IWebExchange webExchange = this.application.buildExchange(request, response);
		    final WebContext ctx = new WebContext(webExchange);
		    templateEngine.process("notice", ctx, response.getWriter());
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    final IWebExchange webExchange = this.application.buildExchange(request, response);
	    final WebContext ctx = new WebContext(webExchange);
	    
	    String headInp = request.getParameter("heading");
	    String contentInp = request.getParameter("content");
	    String contactInp = request.getParameter("contact");
	    
	    nc.addNotice(headInp, contentInp, contactInp);
	    
		Statement stmt  = null;
		Connection cnx = null;
		ResultSet rs = null;
		try {
			cnx = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			System.out.println("Connection Success");
			stmt = cnx.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Notices");
			
			while(rs.next()) {
				
				String heading = rs.getString("heading");
				ctx.setVariable("heading1", heading);
				String content = rs.getString("content");
				ctx.setVariable("content1", content);
				String contact = rs.getString("contact");
				ctx.setVariable("contact1", contact);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 

	    templateEngine.process("notice", ctx, response.getWriter());
	}

}
