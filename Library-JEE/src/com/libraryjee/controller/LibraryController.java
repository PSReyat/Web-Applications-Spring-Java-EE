package com.libraryjee.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import com.libraryjee.dao.BookDAO;
import com.libraryjee.dao.BookDAOImpl;
import com.libraryjee.entity.Book;

public class LibraryController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher dispatcher;
	private BookDAO bookDAO;
	
	public LibraryController(){
		super();
		bookDAO = new BookDAOImpl();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			case "LIST":
				listOfBooks(req, resp);
				break;
			
			case "EDIT":
				singleBook(req, resp);
				break;
				
			case "DELETE":
				deleteBook(req, resp);
				break;
			
			case "SEARCH":
				searchBook(req, resp);
				break;
			
			default:
				listOfBooks(req, resp);
				break;
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		Book book = new Book();
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String isbn = req.getParameter("isbn");
		
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setIsbn(isbn);
		
		if (id.isEmpty() || id == null) {
			if (bookDAO.save(book)) {
				req.setAttribute("message", "Book added");
			}
		}else {
			book.setId(Integer.parseInt(id));
			if(bookDAO.update(book)) {
				req.setAttribute("message", "Book updated");
			}
		}
		
		listOfBooks(req, resp);
	}
	
	public void listOfBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> books = bookDAO.getList();
		
		req.setAttribute("book", books);
		
		dispatcher = req.getRequestDispatcher("/Views/book-list.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	public void singleBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		Book book = bookDAO.getBook(Integer.parseInt(id));
		
		req.setAttribute("book", book);
		
		dispatcher = req.getRequestDispatcher("/Views/book-add.jsp");
		
		dispatcher.forward(req, resp);
		
	}
	
	public void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		bookDAO.delete(Integer.parseInt(id));
		
		listOfBooks(req, resp);
	}
	
	public void searchBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchBook = req.getParameter("search");
		
		List<Book> books = bookDAO.searchList(searchBook);
		
		req.setAttribute("book", books);
		
		dispatcher = req.getRequestDispatcher("/Views/book-search-list.jsp");
		
		dispatcher.forward(req, resp);
	}
	
}
