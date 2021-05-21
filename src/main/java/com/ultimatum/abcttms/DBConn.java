/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ultimatum.abcttms;

import java.sql.*;

/**
 *
 * @author dinithagamage
 */
public class DBConn {
    public static Connection connect(){
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8889/abcttms","root","root");
            return con;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    public static void executeINSERT(String table, String[] values){
        try{
            Connection con = connect();
            Statement stmt = con.createStatement();
            String queryString = "UPDATE " + table + " SET ";
            for(int x = 0; x < values.length; x++){
                queryString = queryString + "'" + values[x] + "'";
                if(x != values.length){
                    queryString = queryString + ", ";
                } else{
                    queryString = queryString + ")";
                }
            }
            stmt.executeQuery(queryString);
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void executeUpdate(String table, String pk, String pkVal, String[] keys, String[] values){
        try{
            Connection con = connect();
            Statement stmt = con.createStatement();
            String queryString = "UPDATE " + table + " SET ";
            for(int x = 0; x < keys.length; x++){
                queryString = queryString + keys[x] + " = '" + values[x] + "'";
                if(x != keys.length){
                    queryString = queryString + ", ";
                }
            }
            queryString = queryString + " WHERE " + pk + " = '" + pkVal + "";
            stmt.executeQuery(queryString);
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void executeDelete(String table, String pk, String pkVal){
        try{
            Connection con = connect();
            Statement stmt = con.createStatement();
            String queryString = "DELETE FROM " + table + " WHERE " + pk + " = '" + pkVal + "'";
            stmt.executeQuery(queryString);
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static ResultSet executeReadRow(String table, String pk, String pkVal){
        try{
            Connection con = connect();
            Statement stmt = con.createStatement();
            String queryString = "SELECT * FROM " + table + " WHERE " + pk + " = '" + pkVal + "'";
            ResultSet rs = stmt.executeQuery(queryString);
            con.close();
            return rs;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static ResultSet executeReadAll(String table){
        try{
            Connection con = connect();
            Statement stmt = con.createStatement();
            String queryString = "SELECT * FROM " + table + "";
            ResultSet rs = stmt.executeQuery(queryString);
            con.close();
            return rs;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
