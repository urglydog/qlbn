/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConnectDB.ConnectionDB;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import src.Enitty.Nuoc;

/**
 *
 * @author nguye
 */
public class ThongKe_DAO {

    public ThongKe_DAO() {
    }
    
//    public void thongKe(Date ngay) {
//		
//		      ConnectionDB.getInstance();
//		Connection con = (Connection) ConnectionDB.getConnectionDB();
//	    String sql = "select od.maSanPham, tenSanPham, sum(od.soLuong) as 'SoLuong', sum(od.gia) as 'TongGia' " +
//                "from ChiTietHoaDon od " +
//                "join HoaDon o on od.maHoaDon=o.maHoaDon " +
//                "join SanPham s on od.maSanPham=s.maSanPham " +
//                "where o.ngayMua = '" + ngay + "' " +
//                "group by od.maSanPham, tenSanPham " +
//                "order by sum(od.soLuong) desc, sum(od.gia) desc";
//		      Statement statement = con.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		 String TenSP = null;
//		 int SL = 0;
//		 double TongGia = 0;
//		while(rs.next()) {
//			  TenSP = rs.getString(2);
//			  SL =  Integer.parseInt(rs.getString(3));
//			  TongGia = Double.parseDouble(rs.getString(4));
//		}
//		System.out.println(TenSP);
//		System.out.println(SL);
//		System.out.println(TongGia);
//	}
	
public void thongKe(LocalDate ngay) throws SQLException {
    ConnectionDB.getInstance().connect(); // Thêm dòng này để kết nối đến cơ sở dữ liệu
    java.sql.Connection con = ConnectionDB.getConnectionDB();
    String sql = "select od.maSanPham, tenSanPham, sum(od.soLuong) as 'SoLuong', sum(od.gia) as 'TongGia' " +
                 "from ChiTietHoaDon od " +
                 "join HoaDon o on od.maHoaDon=o.maHoaDon " +
                 "join SanPham s on od.maSanPham=s.maSanPham " +
                 "where o.ngayMua = '" + ngay + "' " +
                 "group by od.maSanPham, tenSanPham " +
                 "order by sum(od.soLuong) desc, sum(od.gia) desc";
    Statement statement = con.createStatement();
    ResultSet rs = statement.executeQuery(sql);

    while (rs.next()) {
        String TenSP = rs.getString(2);
        int SL =  Integer.parseInt(rs.getString(3));
        double TongGia = Double.parseDouble(rs.getString(4));
        System.out.println(TenSP);
        System.out.println(SL);
        System.out.println(TongGia);
    }
}

    public ArrayList<String[]> thongKe2(LocalDate ngay) throws SQLException {
        ConnectionDB.getInstance().connect(); // Kết nối đến cơ sở dữ liệu
        java.sql.Connection con = ConnectionDB.getConnectionDB();
        String sql = "select tenSanPham, sum(od.soLuong) as 'SoLuong', sum(od.gia) as 'TongGia' " +
                     "from ChiTietHoaDon od " +
                     "join HoaDon o on od.maHoaDon=o.maHoaDon " +
                     "join SanPham s on od.maSanPham=s.maSanPham " +
                     "where o.ngayMua = '" + ngay + "' " +
                     "group by tenSanPham " +
                     "order by sum(od.soLuong) desc, sum(od.gia) desc";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        ArrayList<String[]> resultList = new ArrayList<>();

        while (rs.next()) {
            String tenSanPham = rs.getString("tenSanPham");
            int soLuong = rs.getInt("SoLuong");
            double tongGia = rs.getDouble("TongGia");

            String[] data = {tenSanPham, String.valueOf(soLuong), String.valueOf(tongGia)};
            resultList.add(data);
        }

        return resultList;
    }

    
	public static void main(String[] args) throws SQLException {
		ThongKe_DAO x = new ThongKe_DAO();
               LocalDate today = LocalDate.of(2024, 05, 05);
                x.thongKe(today);
		
	}
}
