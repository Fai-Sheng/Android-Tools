package com.fai.tools.ui.fragments_in_one_activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.fai.tools.R;
import com.fai.tools.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentsDemoNavActivity extends BaseActivity {

    @BindView(R.id.googleBtn)
    Button btnGoogle;

    @BindView(R.id.weChatBtn)
    Button btnWeChat;

    @BindView(R.id.zhihuBtn)
    Button btnZhiHu;

    @Override
    protected void init(Bundle savedInstanceState) {

        ButterKnife.bind(this);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentsDemoNavActivity.this,GoogleMainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragments_nav;
    }
}

