package noticesWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NoticeController {
	
 	public static final String DB_URL = "jdbc:mysql://localhost:3306/Notices";
 	public static final String DB_USER = "prodapt";
 	public static final String DB_PASS = "gaurav@123";

	private List<Notice> notices;
    private int maxNotices;

    public NoticeController() {
        this.notices = new ArrayList<>();
    }
	
    public void addNotice(String heading, String content, String contact) {
    	try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
    	String insertQuery = "INSERT INTO Notices (heading , content , contact) VALUES (?, ?, ?)";
        notices.add(new Notice(heading, content, contact));
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        
        statement.setString(1, heading);
        statement.setString(2, content);
        statement.setString(3, contact);
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
