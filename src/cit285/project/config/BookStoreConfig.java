package cit285.project.config;

import java.io.PrintWriter;
import java.io.StringWriter;

//import cit285.project.services.AdminServices;
//import cit285.project.services.AdminServicesAPI;
import cit285.project.services.BooksServices;
import cit285.project.services.BooksServicesAPI;
import cit285.project.services.UserServices;
import cit285.project.services.UserServicesAPI;

public class BookStoreConfig {

	// the service objects in use, representing all lower layers to the app
	private static BooksServicesAPI booksServices;
	private static UserServicesAPI userServices;
	//private static AdminServicesAPI adminServices;
	
	// set up service API, data access objects
	public static void configureServices()
		throws Exception {	
		try {
			
			booksServices = new BooksServices();
			userServices = new UserServices();
			//adminServices = new AdminServices();
		} catch (Exception e) {
			
		    // rethrow to notify caller (caller should print exception details)
			throw new Exception("Exception in configureServices",e); 
		}
	}
	
	public static String exceptionReport(Exception e) {
		String message = e.toString(); // exception name + message
		if (e.getCause() != null) {
			message += "\n  cause: " + e.getCause();
			if (e.getCause().getCause() != null) {
				message += "\n    cause's cause: " + e.getCause().getCause();
			}
		}
		message += "\n Stack Trace: " + exceptionStackTraceString(e);
		return message;
	}

	private static String exceptionStackTraceString(Throwable e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
	
	public static BooksServicesAPI getBookServices() {
		
		return booksServices;
	}
	
	public static UserServicesAPI getUserServices() {
		
		return userServices;
	}
	
	/*public static AdminServicesAPI getAdminServices() {
		
		return adminServices;
	}*/
}
