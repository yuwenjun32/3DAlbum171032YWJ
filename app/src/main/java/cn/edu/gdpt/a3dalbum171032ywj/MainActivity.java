package cn.edu.gdpt.a3dalbum171032ywj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

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
        initCoverFlow();
        initAnimation();
    }

    private void initAnimation() {
        Animation in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_top);
        Animation out=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slice_out_bottom);
        title.setInAnimation(in);
        title.setOutAnimation(out);
    }

    private void initCoverFlow() {
        AlbumAdapter adapter=new AlbumAdapter(getApplicationContext());
        adapter.setData(dataList);
        coverflow.setAdapter(adapter);
        coverflow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                String[] name={"Girl","Spring Scenety","Summer Scenety","Autumn Scenety","Winter Scenety"};
                title.setText(name[position]);
            }

            @Override
            public void onScrolling() {

            }
        });
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
        title.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater=LayoutInflater.from(getApplicationContext());
                TextView view=(TextView)inflater.inflate(R.layout.item_title,null);
                return view;
            }
        });
    }
}
