package com.company;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

        private String m_conn;
        public CustomerDAO(String m_conn) {
            this.m_conn = m_conn;
        }
        public void creaetDatabase(String name) {
            String url = "jdbc:sqlite:C:\\Users\\yelena\\SQL 3-21.db" + name;
            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        public ArrayList<Customer> getAllCustomer() {

            ArrayList<Customer> customer = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(m_conn)) {

                if (conn != null) {

                    String sql = "SELECT * FROM CUSTOMER";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        Customer e = new Customer(
                                rs.getInt("id"),
                                rs.getString("Firstname"),
                                rs.getString("Lastname"),
                                rs.getInt("numberoforder"),
                                rs.getInt("hight"));
                        customer.add(e);
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return customer;
        }
        public void select(String query) {

            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = query;
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + "\t" +
                                rs.getString("firstname") + "\t" +
                                rs.getString("lastname") + "\t"+
                                rs.getInt("NumberofOrder") + "\t" +
                                rs.getInt("hight")
                        );
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        public void update(String query) {

            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {

                    String sql = query;

                    Statement stmt = conn.createStatement();

                    int result = stmt.executeUpdate(sql);
                    System.out.println(result + " record updated.");
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}
