package com.liu.tohappy.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.liu.tohappy.R;
import com.umeng.analytics.MobclickAgent;

/**
 * @创建者 liuyang
 * @创建时间 2018/10/18 17:22
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.titlebg));

        }
        setContentView(getLayout());
        setTitle(getResources().getString(R.string.app_name));

    }
    public abstract int getLayout();
    public void setTitle(String title){
        ((TextView)findViewById(R.id.umeng_title)).setText(title);
    }

    @SuppressLint("WrongConstant")
    public void setBackVisibily(){
        findViewById(R.id.umeng_back).setVisibility(View.VISIBLE);
        findViewById(R.id.umeng_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBack(view);
            }
        });
    }
    public void clickBack(View view){
        finish();
    }

    // BaseActivity中统一调用MobclickAgent 类的 onResume/onPause 接口
    // 子类中无需再调用
    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this); // 基础指标统计，不能遗漏
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this); // 基础指标统计，不能遗漏
    }
}
