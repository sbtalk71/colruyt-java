package com.demo.interfaces;

public class MainApp {
    public static void main(String[] args) {
        MyConnection db = new OracleDB();

        System.out.println(db.getClass().getName());

        db.getConnection();
        System.out.println(db.getDBInfo());
        System.out.println(MyConnection.releaseVer);
    }
}
