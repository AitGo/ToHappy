package com.liu.tohappy.activity;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.liu.tohappy.R;
import com.liu.tohappy.adapter.SumListAdapter;
import com.liu.tohappy.entity.SumEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 liuyang
 * @创建时间 2018/12/12 15:25
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SumActivity extends Activity implements View.OnClickListener {
    private RecyclerView rv_sums;
    private ImageView iv_back;
    private List<String> mSumList = new ArrayList<>();
    private SumListAdapter mAdapter;
    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos){}
        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {}
        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {}
    };

    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {}
        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {}
        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {}

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        initView();
        initData();
    }

    private void initData() {

        mSumList.add("11111");
        mSumList.add("22222");

        mAdapter = new SumListAdapter(mSumList);

        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(rv_sums);

        // 开启拖拽
        mAdapter.enableDragItem(itemTouchHelper, R.id.tv_content, true);
        mAdapter.setOnItemDragListener(onItemDragListener);

        // 开启滑动删除
        mAdapter.enableSwipeItem();
        mAdapter.setOnItemSwipeListener(onItemSwipeListener);

        rv_sums.setLayoutManager(new LinearLayoutManager(this));
        rv_sums.setAdapter(mAdapter);


    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        rv_sums = (RecyclerView) findViewById(R.id.rv_sums);

        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
