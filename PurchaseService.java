import java.sql.*;

public class PurchaseService {

    public ResultSet getSupplier(String id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql="SELECT supplier_name FROM supplier WHERE supplier_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,id);
        return ps.executeQuery();
    }
    
    
	public ResultSet getMedicine(String id) throws Exception {

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/medical_store",
        "root",
        "12345"
    );

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM medicine WHERE medicine_id = ?"
    );

    ps.setString(1, id);

    return ps.executeQuery();
}

    public ResultSet getPurchaseHistory() throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps=
            con.prepareStatement("SELECT purchase_id, supplier_id, date FROM purchase");
        return ps.executeQuery();
    }

    public ResultSet getPurchaseDetails() throws Exception {
        Connection con = DBConnection.getConnection();

        String q=
        "SELECT pd.purchase_id, pd.medicine_id, m.name, pd.price, pd.quantity, pd.total " +
        "FROM purchase_detail pd INNER JOIN medicine m ON pd.medicine_id = m.medicine_id";

        PreparedStatement ps=con.prepareStatement(q);
        return ps.executeQuery();
    }
}