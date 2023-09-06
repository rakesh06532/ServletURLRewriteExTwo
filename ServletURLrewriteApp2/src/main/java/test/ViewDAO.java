package test;
import java.sql.*;
import java.util.*;
public class ViewDAO {
	ArrayList<BookBean> al=new ArrayList<BookBean>();
	public ArrayList<BookBean> view(){
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from bookdetails49");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				BookBean bb=new BookBean();
				bb.setBCode(rs.getString(1));
				bb.setBName(rs.getString(2));
				bb.setBAuthor(rs.getString(3));
				bb.setBPrice(rs.getFloat(4));
				bb.setBQnty(rs.getInt(5));
				al.add(bb);
			}
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}

}
