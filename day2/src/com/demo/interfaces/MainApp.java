package com.demo.interfaces;

public class MainApp {
    public static void main(String[] args) {
        MyNewConnection db = new IBMDB2();

        System.out.println(db.getClass().getName());

        db.getConnection();
        System.out.println(db.getDBInfo());
        System.out.println(MyConnection.releaseVer);
        db.getDBVendorInfo();
    }
}
