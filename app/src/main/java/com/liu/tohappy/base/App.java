package com.liu.tohappy.base;


import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.liu.tohappy.greendao.DaoMaster;
import com.liu.tohappy.greendao.DaoSession;

/**
 * @创建者 liuyang
 * @创建时间 2018/10/18 16:58
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class App extends Application {

    private static final String TAG = App.class.getName();
    public static final String UPDATE_STATUS_ACTION = "com.umeng.message.example.action.UPDATE_STATUS";
    private        Handler    handler;
    private static DaoSession daoSession;
    private static Context    mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //配置数据库
        setupDatabase();

    }

    private void setupDatabase() {
        //创建数据库shop.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "user_info.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }

    /**
     * 获取全局上下文
     */
    public static Context getContext() {
        return mContext;
    }

}
