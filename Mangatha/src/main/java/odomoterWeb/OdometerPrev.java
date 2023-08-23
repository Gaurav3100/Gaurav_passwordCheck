//package odomoterWeb;
//
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//
//@WebServlet("/Odometer")
//public class OdometerPrev extends HttpServlet {
//    private static final String ODOMETER_CONTROLLER_KEY = "odometerController";
//	private static final long serialVersionUID = 1L;
//	private OdometerController odo;
//	private Share sh;
//	private JakartaServletWebApplication application;
//	private TemplateEngine templateEngine;
//
//	  @Override
//	  public void init(ServletConfig config) throws ServletException {
//	    super.init(config);
//	    sh = new Share();
//        odo = new OdometerController();
//        getServletContext().setAttribute(ODOMETER_CONTROLLER_KEY, odo);
//	    application = JakartaServletWebApplication.buildApplication(getServletContext());
//	    final WebApplicationTemplateResolver templateResolver = 
//	    new WebApplicationTemplateResolver(application);
//	    templateResolver.setTemplateMode(TemplateMode.HTML);
//	    templateResolver.setPrefix("/WEB-INF/templates/");
//	    templateResolver.setSuffix(".html");
//	    templateEngine = new TemplateEngine();
//	    templateEngine.setTemplateResolver(templateResolver);
//	  }
//
//		@Override
//		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		    final IWebExchange webExchange = this.application.buildExchange(request, response);
//		    final WebContext ctx = new WebContext(webExchange);
//		    templateEngine.process("odometer", ctx, response.getWriter());
//		}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	    
//	    final IWebExchange webExchange1 = this.application.buildExchange(request, response);
//	    final WebContext ctx1 = new WebContext(webExchange1);
//	    
//		int nextNum = odo.nextValue();
//		ctx1.setVariable("nextValue", nextNum);
//	    templateEngine.process("odometer", ctx1, response.getWriter());
//		
//	    final IWebExchange webExchange = this.application.buildExchange(request, response);
//	    final WebContext ctx = new WebContext(webExchange);
//	    
//		int prevNum = odo.prevValue(nextNum);
//		ctx.setVariable("prevValue", prevNum);
//	    templateEngine.process("odometer", ctx, response.getWriter());
//
//	}
//
//
//}
