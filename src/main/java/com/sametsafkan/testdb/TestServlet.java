package com.sametsafkan.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
@Slf4j
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String dbUserName = "springstudent";
	private static final String dbPassword = "springstudent";
	private static final String connectionUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
	private static final String driver = "com.mysql.jdbc.Driver";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			throw new ServletException(e1);
		}
		try(Connection conn = DriverManager.getConnection(connectionUrl, dbUserName, dbPassword)){
			PrintWriter outWriter = response.getWriter();	
			outWriter.println("Connection Successfull");
			outWriter.flush();
		}catch(Exception e) {
			log.error("Connection Error...", e);
			throw new ServletException(e);
		}
	}

}
