package com.learning.password;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Servlet implementation class PasswordCheck
 * 
 */

// @webservlet()...anotations
public class PasswordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public boolean check(String input) {
		
        try {
            File myObj = new File("/home/gaurav31/eclipse-workspace/Gaurav_WebProject/src/main/webapp/WEB-INF/passwordDatabase.txt");

            if (!myObj.exists()) {
                System.out.println("File does not exist.");
                return false;
            }

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("Data from file: " + data);
                if (data.equals(input)) {
                    return false;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return true;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String inputPassword = request.getParameter("passCon");
		if(check(inputPassword))out.println("Success!");
		else out.println("Failure!");
	}

}
