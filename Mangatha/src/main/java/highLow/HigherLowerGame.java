package highLow;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@WebServlet("/highLow")
public class HigherLowerGame extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	  private JakartaServletWebApplication application;
	  private HighLowController hcl;
	  private TemplateEngine templateEngine;
	  private int actualNum = 200;

	  @Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    hcl = new HighLowController();
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
	    templateEngine.process("highLow", ctx, response.getWriter());
	}
	
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String input = request.getParameter("highLow");
		int inputNum = Integer.valueOf(input);

		int guess = hcl.checkNumber(inputNum , actualNum);
		
	    final IWebExchange webExchange = this.application.buildExchange(request, response);
	    final WebContext ctx = new WebContext(webExchange);
	    if(guess == 1)ctx.setVariable("feedback", "Guess Lower!");
	    else if(guess == 0) ctx.setVariable("feedback", "Guess Higher!");
	    else {
	    	ctx.setVariable("feedback", "Right Guess!");
	    	actualNum = hcl.reset();
	    }
	    templateEngine.process("highLow", ctx, out);
		
	}

}
