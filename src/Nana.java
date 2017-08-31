import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.newlecture.javaWeb.entity.Notice;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/hello")

public class Nana extends HttpServlet{
	
   public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
   
   {
	  response.setCharacterEncoding("UTF-8");				//������ ������ utf-8�� ����
	  response.setContentType("text/html; chatset=UTF-8"); 	//������ utf-8�� ����
      
	  PrintWriter out = response.getWriter();		//���� ������ Ưȭ�� �ִ� ��
	  /*OutputStream os = response.getOutputStream(); //����Ʈ������ Ưȭ�� ��

      PrintStream out= new PrintStream(os);*/
	  
	  String title = request.getParameter("title");
	  System.out.println(title);
 
	  //----------------------------------------------------------------
	  List<Notice> list = null;
	  
      String sql = "SELECT *FROM Notice where title like ?";

      String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

      // JDBC ����̹� �ε�
      try {
			Class.forName("com.mysql.jdbc.Driver");
	
			// ���� / ����
		    Connection con = DriverManager.getConnection(url, "sist", "cclass");
	
		    // ����
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setString(1, "%" + title + "%");
		    
		    // ��� ��������
		    ResultSet rs = st.executeQuery();
		    
	
		    // Model 
		    list = new ArrayList<>();
		      
		    // ��� ����ϱ�
		    while (rs.next()) {
		       Notice n = new Notice();
		       n.setId(rs.getString("ID"));
		       n.setTitle(rs.getString("TITLE"));
		       //..
		         
		       list.add(n);
		    }
		      rs.close();
		      st.close();
		      con.close();
		      
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

/*----------------------view---------------------------*/
	  out.println("<html>");
	  out.println("<head>");
	  out.println("<meta charset=\"UTF-8\">");
	  out.println("<title>Insert title here</title>");
	  out.println("</head>");
	  out.println("<body>");
	  out.println("<form action=\"hello\">");
	  out.println("<label>�˻���</label>");
	  out.println("<input type=\"text\" name=\"title\"/>");
	  out.println("<input type=\"submit\"/>");
	  out.println("</form>");
	  	for(Notice n : list)
	  	  out.println(n.getTitle() + "<br/>"); //�ؽ�Ʈ�� �ƴϱ� ������ ���̻� println�� �ƴ϶� web�������� �ٹٲ� �� �ִ� �±׸� �̿��ؾ� �Ѵ�.
      	
	  	out.println("</body>");
	  	out.println("</html>");
      
      
      

      
   }
}