package com.liu.tohappy;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.liu.tohappy.base.BaseFragment;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liu on 2018/11/9.
 */

public class FragmentA extends BaseFragment {
    private TextView tv_a;
    @Override
    protected View initView(LayoutInflater inflater) {
        View inflate = inflater.inflate(R.layout.fragment_a,null);
        tv_a = (TextView) inflate.findViewById(R.id.tv_a);
        tv_a.setText("这是我们认识的第" + getDate());
        return inflate;
    }

    private String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date d1 = new   Date(System.currentTimeMillis());//你也可以获取当前时间
            Date d2 = df.parse("2018-10-05");
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);

            return ""+days+"天"+hours+"小时"+minutes+"分";
        }
        catch (Exception e) {
            return null;
        }
    }
}
