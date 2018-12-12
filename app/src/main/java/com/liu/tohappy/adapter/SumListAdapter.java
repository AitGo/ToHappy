package com.liu.tohappy.adapter;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liu.tohappy.R;

import java.util.List;

/**
 * @创建者 liuyang
 * @创建时间 2018/12/12 16:07
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SumListAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {

    public SumListAdapter(List data) {
        super(R.layout.item_sum,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        helper.setText(R.id.tv_content, item);
    }
}
