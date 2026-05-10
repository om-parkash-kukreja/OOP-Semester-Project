import java.sql.*;

public class AuthService {

    public boolean login(String u, String p) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM admin WHERE username=? AND password=?");

            ps.setString(1, u);
            ps.setString(2, p);

            return ps.executeQuery().next();

        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}