package odomoterWeb;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;


@WebServlet("/odometer")
public class Odometer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OdometerController odo;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	private int currVal = 123;

	  @Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    odo = new OdometerController();
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
		    templateEngine.process("odometer", ctx, response.getWriter());
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    final IWebExchange webExchange = this.application.buildExchange(request, response);
	    final WebContext ctx = new WebContext(webExchange);
	    
	    int noOfDigits = Integer.valueOf(request.getParameter("digit"));
	    int currVal = odo.lowestDigitNumber(noOfDigits);
	    
	    String buttonValue = request.getParameter("btn");
	    if (buttonValue != null) {
	        if (buttonValue.equals("PREV-VALUE")) {
	            ctx.setVariable("prevValue", odo.prevValue(currVal, noOfDigits));
	            currVal = odo.prevValue(odo.lowestDigitNumber(noOfDigits), noOfDigits);
	        } else if (buttonValue.equals("NEXT-VALUE")) {
	            ctx.setVariable("nextValue", odo.nextValue(currVal, noOfDigits));
	            currVal = odo.nextValue(currVal, noOfDigits);
	        } else if (buttonValue.equals("RESET")) {
	            currVal = 123;
	            ctx.setVariable("reset", odo.lowestDigitNumber(noOfDigits));
	        }
	    }

	    templateEngine.process("odometer", ctx, response.getWriter());
	}

}
