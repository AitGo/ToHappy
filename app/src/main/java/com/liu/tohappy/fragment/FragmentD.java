package com.liu.tohappy.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.liu.tohappy.R;
import com.liu.tohappy.base.BaseFragment;

/**
 * Created by liu on 2018/11/9.
 */

public class FragmentD extends BaseFragment {
    private TextView tv_d;
    @Override
    protected View initView(LayoutInflater inflater) {
        View inflate = inflater.inflate(R.layout.fragment_d,null);
        tv_d = (TextView) inflate.findViewById(R.id.tv_d);
        tv_d.setText("虽然这个表白迟了，张静思我爱你！ ");
        return inflate;
    }
}
