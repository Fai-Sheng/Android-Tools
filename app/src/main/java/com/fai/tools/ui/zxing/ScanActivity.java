package com.fai.tools.ui.zxing;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.fai.tools.R;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import rx.functions.Action1;

/**
 * 自定义二维码扫描 界面
 */
public class ScanActivity extends FragmentActivity{

    private FragmentManager fragmentManager;
    CaptureFragment captureFragment;
    private static final int REQUEST_CODE = 0;

    private RxPermissions rxPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        initPermissions();

    }


    private void initPermissions()
    {
        rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            Toast.makeText(ScanActivity.this, "获取权限成功", Toast.LENGTH_SHORT).show();
                            initCapture();
                        } else {
                            Toast.makeText(ScanActivity.this, "获取权限失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * 初始化 captureFragment 并替换自定义的 layout : capture_diy_layout
     */
    private void initCapture()
    {
        captureFragment = new CaptureFragment();
        fragmentManager = getSupportFragmentManager();
        //这句话 不可少，告诉captureFragment去加载我们的自定义的 layout
        CodeUtils.setFragmentArgs(captureFragment,R.layout.capture_diy_layout);

        captureFragment.setAnalyzeCallback(analyzeCallback);

        //添加fragment到我们的activity中来
        fragmentManager.beginTransaction().replace(R.id.capture_container,captureFragment).commit();
    }

    /**
     * 完成解析的回调
     */
    private CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            resultIntent.putExtras(bundle);
            ScanActivity.this.setResult(RESULT_OK, resultIntent);
            ScanActivity.this.finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            ScanActivity.this.setResult(RESULT_OK, resultIntent);
            ScanActivity.this.finish();
        }
    };


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
