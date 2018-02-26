package com.bikesystem.sh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.Comment;
import com.bikesystem.sh.dao.CommentDao;
import com.bikesystem.sh.service.ICommentService;
import com.bikesystem.sh.service.commentService;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICommentService commentservice; 
   
    public CommentServlet() {
        super();
        commentservice=new commentService(new CommentDao());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment=request.getParameter("comment");
		if(comment!=null || !"".equals(comment)){
			boolean addComment=commentservice.saveComment(1, comment, comment, comment, comment, comment, comment, comment);
			if(addComment){
				request.setAttribute("message", new Comment());
			}
		}
		request.getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);
	}
	

}
