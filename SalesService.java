import java.sql.*;

public class SalesService {

    public ResultSet getCustomer(String id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT name FROM customer WHERE customer_id=?");
        ps.setString(1,id);
        return ps.executeQuery();
    }

    public ResultSet getMedicine(String id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT * FROM medicine WHERE medicine_id=?");
        ps.setString(1,id);
        return ps.executeQuery();
    }

    public ResultSet getSalesHistory() throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT sale_id, customer_id, date FROM sales");
        return ps.executeQuery();
    }

    public ResultSet getSalesDetails() throws Exception {
        Connection con = DBConnection.getConnection();
        String q="SELECT Sales_Detail.sale_id, Sales_Detail.medicine_id, medicine.name, Sales_Detail.price, Sales_Detail.quantity, Sales_Detail.total FROM Sales_Detail INNER JOIN medicine ON Sales_Detail.medicine_id = medicine.medicine_id";
        PreparedStatement ps=con.prepareStatement(q);
        return ps.executeQuery();
    }
}