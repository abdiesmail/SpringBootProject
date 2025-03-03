package org.example.SpringBootMVCProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdoctDao {

    Connection conn = null;

    public ProdoctDao() {
        try {
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/springProject","postgres","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product p) {
        String query = "insert into product (name,type,place,warranty) values (?,?,?,?)";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2, p.getType());
            st.setString(3, p.getPlace());
            st.setInt(4,p.getWarranty());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findAll() {
        List<Product> allProduct = new ArrayList<>();
        String query = "select name,type,place,warranty from product";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                allProduct.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allProduct;
    }

    public List<Product> findByName(String name) {
        List<Product> allProduct = new ArrayList<>();
        String query = "select name,type,place,warranty from product where name = ?";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,name);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                allProduct.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allProduct;
    }

    public List<Product> findLessThanWarranty(int year) {
        List<Product> allProduct = new ArrayList<>();
        String query = "select name,type,place,warranty from product where warranty < ?";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,year);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                allProduct.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allProduct;
    }

    public List<Product> findByText(String text) {
        List<Product> allProduct = new ArrayList<>();
        String query = "select name,type,place,warranty from product where concat (name,type,place) ilike ?";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,"%"+text+"%");
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                allProduct.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allProduct;
    }
}
