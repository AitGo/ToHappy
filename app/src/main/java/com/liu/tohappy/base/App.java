package com.liu.tohappy.base;


import android.app.Application;
import android.os.Handler;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;
import java.lang.reflect.Field;

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
    private Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        //设置LOG开关，默认为false
        UMConfigure.setLogEnabled(true);
        try {
            Class<?> aClass = Class.forName("com.umeng.commonsdk.UMConfigure");
            Field[] fs = aClass.getDeclaredFields();
            for (Field f:fs){
                Log.e(TAG,"ff="+f.getName()+"   "+f.getType().getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口
//        UMConfigure.init(this, "5bc84955f1f5562fca0000bb", "Umeng", UMConfigure.DEVICE_TYPE_PHONE,
//                "");
        //PushSDK初始化(如使用推送SDK，必须调用此方法)
//        initUpush();

/*
注意：如果您已经在AndroidManifest.xml中配置过appkey和channel值，可以调用此版本初始化函数。
*/
        UMConfigure.init(this,UMConfigure.DEVICE_TYPE_PHONE , "");
    }


}
