package com.liu.tohappy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liu.tohappy.R;
import com.liu.tohappy.base.App;
import com.liu.tohappy.entity.SumEntity;
import com.liu.tohappy.event.MessageEvent;
import com.mcxtzhang.swipemenulib.CstViewPager;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * @创建者 liuyang
 * @创建时间 2018/12/12 16:07
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SumListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<SumEntity> sums;

    public SumListAdapter(Context mContext, List<SumEntity> sums) {
        this.mContext = mContext;
        this.sums = sums;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sums.size();
    }

    @Override
    public Object getItem(int position) {
        return sums.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_sum, null);
            holder = new ViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.tv_content);
            holder.delete = (Button) convertView.findViewById(R.id.btn_delete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.content.setText(sums.get(position).getContent());
        final View finalConvertView = convertView;
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getDaoInstant().delete(sums.get(position));
                ((SwipeMenuLayout) finalConvertView).quickClose();
                EventBus.getDefault().post(new MessageEvent(MessageEvent.MSG_ADD_SUCCESS));
            }
        });
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent(sums.get(position).getId() + ""));
            }
        });
        return convertView;
    }

    private class ViewHolder {
        TextView content;
        Button   delete;
    }
}
