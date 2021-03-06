package readsense.face24.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;
import readsense.face24.R;
import readsense.face24.activity.base.BaseActivity;
import readsense.face24.faceSdk.FaceSet;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView faceVersion;//sdk版本
    private String appVersion = "";//app版本

//    private TextView faceDemo;//演示
    private TextView faceExamples;//详细调用例子
    private TextView register_demo;//额外抽取出来的注册演示
    private FaceSet faceSet;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        //获取相关权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                        } else {
                            showLongToast(MainActivity.this, "请同意软件的权限，才能继续使用");
                        }
                    }
                });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
//        faceDemo = findViewById(R.id.face_demo);
        faceExamples = findViewById(R.id.face_examples);
        register_demo = findViewById(R.id.register_demo);
        faceVersion = findViewById(R.id.face_version);


        faceSet = new FaceSet(getApplication());
        faceSet.startTrack(270);
        appVersion = faceSet.getSdkVersion();
        faceSet.stopTrack();
        faceVersion.setText("app-v : " + appVersion);
    }

    @Override
    protected void initEvent() {
//        faceDemo.setOnClickListener(this);
        faceExamples.setOnClickListener(this);
        register_demo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.face_demo://
//                Intent faceDemoIntent = new Intent(MainActivity.this, FaceDemoActivity.class);
//                startActivity(faceDemoIntent);
//                break;
            case R.id.face_examples://详细例子
                Intent faceExamplesIntent = new Intent(MainActivity.this, FaceExamplesActivity.class);
                startActivity(faceExamplesIntent);
                break;
            case R.id.register_demo://详细例子
                Intent registerIntent = new Intent(MainActivity.this, FaceRegistActivity.class);
                startActivity(registerIntent);
                break;
            default:
                break;
        }
    }

}
