package com.demo.misc;
public interface MyConnection {
   String releaseVer="1.0.1";
    public void getConnection();
    public String getDBInfo();
    default public String getProductInfo(){
        return "need to override this method";
    };

}
