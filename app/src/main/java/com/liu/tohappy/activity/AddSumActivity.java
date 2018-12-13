package com.liu.tohappy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.liu.tohappy.R;
import com.liu.tohappy.base.App;
import com.liu.tohappy.entity.SumEntity;
import com.liu.tohappy.event.MessageEvent;
import com.liu.tohappy.greendao.SumEntityDao;

import org.greenrobot.eventbus.EventBus;

/**
 * @创建者 liuyang
 * @创建时间 2018/12/13 9:45
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class AddSumActivity extends Activity implements View.OnClickListener {

    private EditText et_content;
    private ImageView iv_close;
    private Button btn_confirm;
    private Button btn_cancel;
    private String id;
    private int type;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_add);
        initView();
        initData();
    }

    private void initData() {
        type = getIntent().getIntExtra("type",2);
        id = getIntent().getStringExtra("id");
        if(type == 1) {
            SumEntity selectSum = App.getDaoInstant().queryBuilder(SumEntity.class).where(SumEntityDao.Properties.Id.eq(id)).unique();
            et_content.setText(selectSum.getContent());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        et_content = (EditText) findViewById(R.id.et_content);
        iv_close = (ImageView) findViewById(R.id.iv_add_close);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_confirm = (Button) findViewById(R.id.btn_confirm);

        iv_close.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_add_close:
                finish();
                break;
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_confirm:
                String content = et_content.getText().toString().trim();
                if(content.equals("") || content == null) {
                    Toast.makeText(getApplicationContext(), "你还想添加个空？！！！", Toast.LENGTH_LONG).show();
                    break;
                }
                SumEntity sum = new SumEntity(null,content);
                if(type == 0) {
                    App.getDaoInstant().insert(sum);
                }else if(type == 1) {
                    sum.setId(Long.valueOf(id));
                    App.getDaoInstant().update(sum);
                }

                Toast.makeText(getApplicationContext(), "添加成功啦~~~", Toast.LENGTH_LONG).show();
                EventBus.getDefault().post(new MessageEvent(MessageEvent.MSG_ADD_SUCCESS));
                finish();
                break;
        }
    }
}
