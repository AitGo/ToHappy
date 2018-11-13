package com.liu.tohappy.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.liu.tohappy.R;
import com.liu.tohappy.base.BaseFragment;

/**
 * Created by liu on 2018/11/9.
 */

public class FragmentC extends BaseFragment {
    private TextView tv_c;
    @Override
    protected View initView(LayoutInflater inflater) {
        View inflate = inflater.inflate(R.layout.fragment_c,null);
        tv_c = (TextView) inflate.findViewById(R.id.tv_c);
        tv_c.setText("我就是看到这张照片那时候喜欢上了你");
        return inflate;
    }
}
