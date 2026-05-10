import java.sql.*;

public class MedicineService {

    public ResultSet getAll() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery("SELECT * FROM medicine");
    }

    public ResultSet search(String col, String val) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM medicine WHERE " + col + "=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, val);
        return ps.executeQuery();
    }

    public void add(String id,String category_id,String name,String brand,
                    int quantity,double price,String mfg,String exp) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql="INSERT INTO medicine VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,id);
        ps.setString(2,category_id);
        ps.setString(3,name);
        ps.setString(4,brand);
        ps.setInt(5,quantity);
        ps.setDouble(6,price);
        ps.setString(7,mfg);
        ps.setString(8,exp);

        ps.executeUpdate();
    }

    public void update(String id,String category_id,String name,String brand,
                       int quantity,double price,String mfg,String exp) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql="UPDATE medicine SET category_id=?,name=?,brand=?,quantity=?,price=?,mfg=?,exp=? WHERE medicine_id=?";
        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,category_id);
        ps.setString(2,name);
        ps.setString(3,brand);
        ps.setInt(4,quantity);
        ps.setDouble(5,price);
        ps.setString(6,mfg);
        ps.setString(7,exp);
        ps.setString(8,id);

        ps.executeUpdate();
    }

    public void delete(String id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("DELETE FROM medicine WHERE medicine_id=?");
        ps.setString(1,id);
        ps.executeUpdate();
    }
}