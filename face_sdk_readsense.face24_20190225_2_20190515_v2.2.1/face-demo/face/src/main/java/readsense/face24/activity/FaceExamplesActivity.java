package readsense.face24.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import readsense.face24.R;
import readsense.face24.activity.fragment.FaceAttributesFragment;
import readsense.face24.activity.fragment.FaceConversionFragment;
import readsense.face24.activity.fragment.FaceIDCardRecoFragment;

public class FaceExamplesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_examples);
    }


    //测试
    public void test(View v) {

    }

    //人脸识别
    public void FaceRecognitionClick(View v) {

    }

    //人证识别
    public void IDCardRecognitionClick(View v) {
        FaceIDCardRecoFragment fragment = new FaceIDCardRecoFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ex_fragment, fragment);
        transaction.commit();
    }

    //人脸注册
    public void registClick(View v) {
    }

    //人脸属性提取
    public void FaceAttributesClick(View v) {
        FaceAttributesFragment fragment = new FaceAttributesFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ex_fragment, fragment);
        transaction.commit();
    }

    //人脸特征提取
    public void FaceFeatureClick(View v) {

    }

    //特征转换类型
    public void FaceConversionClick(View v) {
        FaceConversionFragment fragment = new FaceConversionFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ex_fragment, fragment);
        transaction.commit();
    }
}
