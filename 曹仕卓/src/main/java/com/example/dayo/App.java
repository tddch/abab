package com.example.dayo;

import android.app.Application;

import com.example.dayo.db.DaoMaster;
import com.example.dayo.db.DaoSession;

public class App extends Application {

    public static DaoSession daoSession;

    @Override//
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper person = new DaoMaster.DevOpenHelper(this, "person");
        daoSession = new DaoMaster(person.getWritableDatabase()).newSession();
    }
}
