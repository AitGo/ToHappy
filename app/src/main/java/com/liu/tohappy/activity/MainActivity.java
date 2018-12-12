package com.liu.tohappy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.aohanyao.transformer.library.CardPageTransformer;
import com.aohanyao.transformer.library.conf.OnPageTransformerListener;
import com.aohanyao.transformer.library.conf.PageTransformerConfig;
import com.liu.tohappy.R;
import com.liu.tohappy.adapter.MyPagerAdapter;
import com.liu.tohappy.fragment.FragmentA;
import com.liu.tohappy.fragment.FragmentB;
import com.liu.tohappy.fragment.FragmentC;
import com.liu.tohappy.fragment.FragmentD;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private MyPagerAdapter adapter;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    private FragmentD fragmentD;
    private ImageView menu;
    private DrawerLayout dl_menu;
    private Button btn_sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = (ImageView) findViewById(R.id.iv_menu);
        dl_menu = (DrawerLayout) findViewById(R.id.dl_menu);
        btn_sum = (Button) findViewById(R.id.btn_sum);

        menu.setOnClickListener(this);
        btn_sum.setOnClickListener(this);

        ViewPager vpMain = (ViewPager) findViewById(R.id.vpMain);
        vpMain.setOffscreenPageLimit(4);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();
        fragmentD = new FragmentD();
        fragments.add(fragmentA);
        fragments.add(fragmentB);
        fragments.add(fragmentC);
        fragments.add(fragmentD);

        adapter = new MyPagerAdapter(getSupportFragmentManager(),fragments);
        vpMain.setAdapter(adapter);

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_menu:
                dl_menu.openDrawer(Gravity.LEFT);
                break;
            case R.id.btn_sum:
                Intent intent = new Intent(MainActivity.this,SumActivity.class);
                startActivity(intent);
                dl_menu.closeDrawer(Gravity.LEFT);
                break;
        }
    }
}
