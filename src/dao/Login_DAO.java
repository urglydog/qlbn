package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login_DAO {
    
    public boolean authenticateUser(String username, String password) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
           ConnectDB.ConnectionDB.getInstance().connect();// Gọi phương thức connect từ ConnectionDB
            con = ConnectDB.ConnectionDB.getConnectionDB();
            String query = "SELECT * FROM [User] WHERE username COLLATE SQL_Latin1_General_CP1_CS_AS = ? AND password COLLATE SQL_Latin1_General_CP1_CS_AS = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username); // Không cần chuyển đổi chữ hoa/thường ở đây
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // User tồn tại trong cơ sở dữ liệu
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Không tìm thấy user trong cơ sở dữ liệu hoặc có lỗi xảy ra
        return false;
    }
}
