package com.liu.tohappy.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.ClipboardManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.liu.tohappy.R;
import com.liu.tohappy.adapter.SumListAdapter;
import com.liu.tohappy.base.App;
import com.liu.tohappy.entity.SumEntity;
import com.liu.tohappy.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @创建者 liuyang
 * @创建时间 2018/12/12 15:25
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SumActivity extends Activity implements View.OnClickListener {

    private ListView  lv_sums;
    private ImageView iv_back;
    private ImageView iv_add;
    private ImageView iv_getsum;
    private List<SumEntity> mSumList = new ArrayList<>();
    private SumListAdapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        EventBus.getDefault().register(this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initData() {
        mSumList.addAll(App.getDaoInstant().getSumEntityDao().loadAll());
        mAdapter = new SumListAdapter(this,mSumList);
        lv_sums.setAdapter(mAdapter);


    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_add = (ImageView) findViewById(R.id.iv_add);
        lv_sums = (ListView) findViewById(R.id.lv_sums);
        iv_getsum = (ImageView) findViewById(R.id.iv_getsum);

        iv_add.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_getsum.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:
                Intent intent = new Intent(SumActivity.this,AddSumActivity.class);
                intent.putExtra("type",0);
                startActivity(intent);
                break;
            case R.id.iv_getsum:
                if(mSumList.size() >= 2) {
                    getSum();
                }
                break;
        }
    }

    public void getSum() {
        Random random=new Random();
        int position1 = random.nextInt(mSumList.size()-1);
        int position2 = random.nextInt(mSumList.size()-1);
        if(position1 == position2) {
            position2 = random.nextInt(mSumList.size()-1);
        }
        String contentAll = mSumList.get(position1).getContent() + "\n" + mSumList.get(position2).getContent();
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        // 将文本内容放到系统剪贴板里。
        cm.setText(contentAll);
        Toast.makeText(getApplicationContext(),contentAll,Toast.LENGTH_LONG).show();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {
        if(messageEvent.getMessage().equals(MessageEvent.MSG_ADD_SUCCESS)) {
            mSumList.clear();
            mSumList.addAll(App.getDaoInstant().getSumEntityDao().loadAll());
            mAdapter.notifyDataSetChanged();
        } else {
            Intent intent = new Intent(SumActivity.this,AddSumActivity.class);
            intent.putExtra("id",messageEvent.getMessage());
            intent.putExtra("type",1);
            startActivity(intent);
        }
    }


}
