package com.company;

import java.sql.*;
import java.util.*;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

           CustomerDAO custDAO = new CustomerDAO( "jdbc:sqlite:C:\\Users\\yelena\\SQL 3-21.db");

            custDAO.select("Select * from CUSTOMER");
            System.out.println("=====================");
            custDAO.update("UPDATE CUSTOMER \n" +
                            "SET NUMBEROFORDER =NUMBEROFORDER +1 \n" +
                             "WHERE ID >0");
             System.out.println("=====================");

            ArrayList<Customer> customers = custDAO.getAllCustomer();

            Collections.sort(customers, new CustomerCompareByOrder());
            Collections.sort(customers,new CustomerCompareByLastName());

            Iterator<Customer> iter = customers.iterator();
            while (iter.hasNext()) {
            System.out.println(iter.next());
        }
               }
            }

















