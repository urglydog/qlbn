/*
* @ (#) Nuoc_DAO.java   1.0     Apr 24, 2024
*
*Copyright (c) 2024 IUH. All rights reserved
 */
package dao;

/*
*@Deccription:
*@author: Thien Nguyen
*@date: Apr 24, 2024
*@version: 1.0
 */
import ConnectDB.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import src.Enitty.Nuoc;
import java.util.List;

public class Nuoc_DAO {

    public Nuoc_DAO() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<Nuoc> getAllList() throws SQLException {
        ArrayList<Nuoc> ds = new ArrayList<>();

        ConnectionDB.getInstance();
        Connection con = ConnectionDB.getConnectionDB();
        String sql = "select * from SanPham";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            String maSanPham = rs.getString(1);
            String maLoai = rs.getString(2);
            String maSize = rs.getString(3);
            String tenSanPham = rs.getString(4);
            String danhMuc = rs.getString(5);
            double gia = Double.parseDouble(rs.getString(6));
            String moTa = rs.getString(7);
            Nuoc x = new Nuoc(maSanPham, maLoai, maSize, tenSanPham, danhMuc, gia, moTa);
            ds.add(x);
        }
        return ds;
    }

    public Nuoc getProduct(String ma) throws SQLException {

        ConnectionDB.getInstance();
        Connection con = ConnectionDB.getConnectionDB();
        String sql = "select * from SanPham where maSanPham = '" + ma + "'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        Nuoc x = null;
        while (rs.next()) {
            String maSanPham = rs.getString(1);
            String maLoai = rs.getString(2);
            String maSize = rs.getString(3);
            String tenSanPham = rs.getString(4);
            String danhMuc = rs.getString(5);
            double gia = Double.parseDouble(rs.getString(6));
            String moTa = rs.getString(7);
            x = new Nuoc(maSanPham, maLoai, maSize, tenSanPham, danhMuc, gia, moTa);
        }
        return x;
    }

    public ArrayList<Nuoc> getAllListByType(String maLoai) throws SQLException {
        ArrayList<Nuoc> ds = new ArrayList<>();

        ConnectionDB.getInstance();
        Connection con = ConnectionDB.getConnectionDB();

        // Sử dụng PreparedStatement để tránh lỗi SQL Injection
        String sql = "select * from SanPham where maLoai = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, maLoai);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String maSanPham = rs.getString(1);
            String maL = rs.getString(2);
            String maSize = rs.getString(3);
            String tenSanPham = rs.getString(4);
            String danhMuc = rs.getString(5);
            double gia = Double.parseDouble(rs.getString(6));
            String moTa = rs.getString(7);
            Nuoc x = new Nuoc(maSanPham, maL, maSize, tenSanPham, danhMuc, gia, moTa);
            ds.add(x);
        }

        return ds;
    }

    public Nuoc getProductByCode(String maSanPham) throws SQLException {
        Nuoc product = null;

        ConnectionDB.getInstance();
        Connection con = ConnectionDB.getConnectionDB();

        String sql = "SELECT * FROM SanPham WHERE maSanPham = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, maSanPham);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            String maLoai = rs.getString("maLoai");
            String maSize = rs.getString("maSize");
            String tenSanPham = rs.getString("tenSanPham");
            String danhMuc = rs.getString("danhMuc");
            double gia = rs.getDouble("gia");
            String moTa = rs.getString("moTa");

            product = new Nuoc(maSanPham, maLoai, maSize, tenSanPham, danhMuc, gia, moTa);
        }

        return product;
    }

    public void addProduct(Nuoc product) throws SQLException {
        ConnectionDB.getInstance();
        Connection con = ConnectionDB.getConnectionDB();

        String sql = "INSERT INTO SanPham(maSanPham, maLoai, maSize, tenSanPham, danhMuc, gia, moTa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, product.getMaSanPham());
        preparedStatement.setString(2, product.getMaLoai());
        preparedStatement.setString(3, product.getMaSize());
        preparedStatement.setString(4, product.getTenSanPham());
        preparedStatement.setString(5, product.getDanhMuc());
        preparedStatement.setDouble(6, product.getGia());
        preparedStatement.setString(7, product.getMoTa());

        preparedStatement.executeUpdate();
    }

    public void deleteProduct(String maSanPham) throws SQLException {
        ConnectionDB.getInstance();
        Connection con = ConnectionDB.getConnectionDB();

        String sql = "DELETE FROM SanPham WHERE maSanPham = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, maSanPham);

        preparedStatement.executeUpdate();
    }

    public void updateProduct(Nuoc product) throws SQLException {
        ConnectionDB.getInstance();
        Connection con = ConnectionDB.getConnectionDB();

        String sql = "UPDATE SanPham SET maLoai = ?, maSize = ?, tenSanPham = ?, danhMuc = ?, gia = ?, moTa = ? WHERE maSanPham = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, product.getMaLoai());
        preparedStatement.setString(2, product.getMaSize());
        preparedStatement.setString(3, product.getTenSanPham());
        preparedStatement.setString(4, product.getDanhMuc());
        preparedStatement.setDouble(5, product.getGia());
        preparedStatement.setString(6, product.getMoTa());
        preparedStatement.setString(7, product.getMaSanPham());

        preparedStatement.executeUpdate();
    }

    public boolean isProductExistsInList(String maSP) throws SQLException {
        List<Nuoc> productList = getAllList();
        for (Nuoc product : productList) {
            if (product.getMaSanPham().equals(maSP)) {
                return true;
            }
        }
        return false;
    }
}
