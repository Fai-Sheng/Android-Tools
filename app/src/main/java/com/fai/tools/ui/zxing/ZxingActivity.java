package com.fai.tools.ui.zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fai.tools.utils.ImageUtil;
import com.fai.tools.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class ZxingActivity extends FragmentActivity {

    private Button btnToScanActivity;
    private TextView textResult;
    private Button btnCreateImg;
    private ImageView imgView;
    private EditText editImgContent;
    private Button btnParseImg;
    private CheckBox checkBox;

    private static final int REQUEST_CODE = 0;
    private static final int REQUEST_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);

        init();
    }


    private void init()
    {
        btnToScanActivity = findViewById(R.id.to_scan_acty);
        textResult = findViewById(R.id.result_text);
        btnCreateImg = findViewById(R.id.btn_create_img);
        imgView = findViewById(R.id.img);
        editImgContent = findViewById(R.id.edit_img_content);
        btnParseImg = findViewById(R.id.btn_parse_img);
        checkBox = findViewById(R.id.checkbox);

        btnParseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE);
            }
        });

        btnCreateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editImgContent.getText().toString().trim();

                if(TextUtils.isEmpty(str))
                {
                    Toast.makeText(ZxingActivity.this,"请输入二维码的内容",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if(checkBox.isChecked())
                    {
                        Bitmap logo = BitmapFactory.decodeResource(getResources(),R.mipmap.jian);
                        Bitmap bitmap = CodeUtils.createImage(str,200,200,logo);

                        imgView.setImageBitmap(bitmap);
                    }
                    else
                    {
                        Bitmap bitmap = CodeUtils.createImage(str,200,200,null);
                        imgView.setImageBitmap(bitmap);
                    }

                }
            }
        });

        btnToScanActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZxingActivity.this,ScanActivity.class);
                ZxingActivity.this.startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE)
        {
            if(data == null)
            {
                return;
            }

            int result = data.getIntExtra(CodeUtils.RESULT_TYPE,CodeUtils.RESULT_FAILED);

            if(result == CodeUtils.RESULT_SUCCESS)
            {
                Toast.makeText(this,"解析成功",Toast.LENGTH_SHORT).show();
                textResult.setText(data.getStringExtra(CodeUtils.RESULT_STRING));
            }
            else
            {
                Toast.makeText(this, "解析失败", Toast.LENGTH_SHORT).show();
            }
        }

        else if (requestCode == REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                try {
                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
                        @Override
                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                            Toast.makeText(ZxingActivity.this, "解析结果:" + result, Toast.LENGTH_LONG).show();

                            textResult.setText(result);
                        }

                        @Override
                        public void onAnalyzeFailed() {
                            Toast.makeText(ZxingActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
