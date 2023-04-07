import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Login extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();


        String name=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body bgcolor=\"#dddddd\">");


        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/class_test";

            Connection con=DriverManager.getConnection(url,"root","root");

            Statement st=con.createStatement();

            String quer="Select * from info where username='"+name+"' ";

            ResultSet rs = st.executeQuery( quer );

            int check=0;
            while(rs.next()){

                String dname = rs.getString("username");
                String dpassword = rs.getString("password");
                if(password.equals(dpassword) && name.equals(dname))
                {
                    boolean admin=rs.getBoolean("admin");
                    if(admin){
                        String str = "type";
                        HttpSession session = request.getSession(true);
                        session.setAttribute(str, "admin");
                        session.setAttribute("password",password);
                        response.sendRedirect("./AdminHome.jsp");
                        check=1;
                    }
                    else
                    {
                    	String str = "type";
                        HttpSession session = request.getSession(true);
                        session.setAttribute(str, "user");
                        session.setAttribute("password",password);
                        response.sendRedirect("./SimpleHome.jsp");
                        check=1;
                    }
                    break;

                }
            }

            if(check==0){
                out.println("<h1>Sorry wrong password entered </h1>");
                out.println("<a href='./login.html'><button style='background-color: red; color: white; padding: 10px 20px; border-radius: 5px;'>Retry</button></a>");
            }
            out.println("</body></html>");
            st.close();
            con.close();

        }catch(Exception e){

            out.println(e);
        }

    }

}
