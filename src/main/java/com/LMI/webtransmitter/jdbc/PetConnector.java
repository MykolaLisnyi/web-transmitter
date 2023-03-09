package com.LMI.webtransmitter.jdbc;

import java.sql.*;

public class PetConnector {
    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/petstoredb";
    private final String DB_LOGIN = "root";
    private final String DB_PASSWORD = "root";

    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;

    public Statement getStatement() {
        return stmt;
    }

    public PreparedStatement initPreparedStatement(String query) {
        try {
            pstmt = con.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public PetConnector() {
        initDBDriver();
        initConnection();
    }

    private void initDBDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() {
        try {
            con = DriverManager.getConnection(DB_CONNECTION_URL, DB_LOGIN, DB_PASSWORD);
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
