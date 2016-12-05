package com.csciOOD;

import java.sql.*;

public class DataStore {
    private Connection C = null;

    public DataStore (){
        initConnection();
    }

//    public static void main(String args[]) {
//
//    }

    private void initConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            C = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        // Try to create our Tables, but ignore if they exist already
        try {
            Statement stmt = C.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS saved_games " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    " score INT, " +
                    " health TINYINT, " +
                    " player_position_x SMALLINT, " +
                    " player_position_y SMALLINT, " +
                    " object_type CHARACTER(30), " +
                    " object_position_x SMALLINT, " +
                    " object_position_y SMALLINT )";

            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        // Try to add the High Scores table
        try {
            Statement stmt = C.createStatement();
            String sql = "";

            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public boolean SaveGame(){
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            C = DriverManager.getConnection("jdbc:sqlite:test.db");
            C.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = C.createStatement();
            String sql = "INSERT INTO saved_games (ID,score,health,player_position_x,player_position_y,object_type,object_position_x,object_position_y) " +
                    "VALUES (1, 300, 40, 30, 30, 'butterfly', 500, 30 );";
            stmt.executeUpdate(sql);

            stmt.close();

            C.commit();

            return true;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);

            return false;
        }
    }


}
