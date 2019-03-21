package cn.edu.gdpt.a3dalbum171032ywj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextSwitcher;

import com.itheima.coverflow.ui.FeatureCoverFlow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FeatureCoverFlow coverflow;
    private TextSwitcher title;
    private List<AlbumBean> dataList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        dataList.add(new AlbumBean(R.drawable.img_1,"Girl"));
        dataList.add(new AlbumBean(R.drawable.img_2,"Spring Scenety"));
        dataList.add(new AlbumBean(R.drawable.img_3,"Summer Scenety"));
        dataList.add(new AlbumBean(R.drawable.img_4,"Autumn Scenety"));
        dataList.add(new AlbumBean(R.drawable.img_5,"Winter Scenety"));
    }

    private void initView() {
        coverflow=(FeatureCoverFlow)findViewById(R.id.fcf_coverfiow);
        title=(TextSwitcher)findViewById(R.id.ts_title);
        coverflow.setCoverWidth(315);
        coverflow.setCoverHeight(488);
        coverflow.setMaxScaleFactor(1.5f);
        coverflow.setReflectionGap(0);
        coverflow.setRotationTreshold(0.5f);
        coverflow.setScalingThreshold(0.5f);
        coverflow.setSpacing(0.6f);
    }
}
