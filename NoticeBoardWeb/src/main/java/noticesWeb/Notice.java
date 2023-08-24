package noticesWeb;

import java.io.*;
import java.util.*;

public class Notice {

	    private String heading;
	    private String text;
	    private String contact;

	    public Notice(String heading, String text, String contact) {
	        this.heading = heading;
	        this.text = text;
	        this.contact = contact;
	    }

	    public String getHeading() {
	        return heading;
	    }

	    public String getText() {
	        return text;
	    }

	    public String getContact() {
	        return contact;
	    }

	    @Override
	    public String toString() {
	        return "Heading: " + heading + "\n" +
	               "Text: " + text + "\n" +
	               "Contact: " + contact + "\n";
	    }
	}

	

