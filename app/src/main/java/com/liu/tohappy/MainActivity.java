package com.liu.tohappy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.aohanyao.transformer.library.CardPageTransformer;
import com.aohanyao.transformer.library.conf.OnPageTransformerListener;
import com.aohanyao.transformer.library.conf.PageTransformerConfig;
import com.liu.tohappy.base.BaseActivity;
import com.umeng.commonsdk.UMConfigure;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vpMain = (ViewPager) findViewById(R.id.vpMain);


            List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add("第"+i+"个View");
            }


        vpMain.setAdapter(new MyPagerAdapter(this,list));


        vpMain.setPageTransformer(true, CardPageTransformer.getBuild()//建造者模式
                .addAnimationType(PageTransformerConfig.ROTATION)//默认动画 default animation rotation  旋转  当然 也可以一次性添加两个  后续会增加更多动画
                .setRotation(-45)//旋转角度
                .addAnimationType(PageTransformerConfig.ALPHA)//默认动画 透明度 暂时还有问题
                .setViewType(1)
                .setOnPageTransformerListener(new OnPageTransformerListener() {
                    @Override
                    public void onPageTransformerListener(View page, float position) {
                        //你也可以在这里对 page 实行自定义动画 cust anim
                    }
                })
                .setTranslationOffset(40)
                .setScaleOffset(80)
                .create());

    }
}
