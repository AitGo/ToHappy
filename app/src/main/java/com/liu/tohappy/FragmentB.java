package com.liu.tohappy;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.liu.tohappy.base.BaseFragment;

/**
 * Created by liu on 2018/11/9.
 */

public class FragmentB extends BaseFragment {
    private TextView tv_b;
    @Override
    protected View initView(LayoutInflater inflater) {
        View inflate = inflater.inflate(R.layout.fragment_b,null);
        tv_b = (TextView) inflate.findViewById(R.id.tv_b);
        tv_b.setText("对你最初的印象还是婚礼接亲的视频，那时候就觉得你性格特别好");
        return inflate;
    }
}
