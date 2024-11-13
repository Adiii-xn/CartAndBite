package com.system.CartAndBiteMain;

import com.system.Database.SystemDB;
import com.system.LoginAndCreate.LoginAcc;

public class RunSystem {
    public static void main(String[] args) {

        new SystemDB();
        LoginAcc.main(args);
    }
}
