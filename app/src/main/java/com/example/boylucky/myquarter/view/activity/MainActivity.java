package com.example.boylucky.myquarter.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boylucky.myquarter.R;
import com.example.boylucky.myquarter.adapter.MyListAdapter;
import com.example.boylucky.myquarter.view.fragment.Cross_talk_frag;
import com.example.boylucky.myquarter.view.fragment.Recommend_frag;
import com.example.boylucky.myquarter.view.fragment.Video_frag;
import com.example.boylucky.myquarter.view.widget.SlidingMenu;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Integer> img;
    private List<String> tv_list;
    /**
     * 推荐======
     */
    private TextView mText;
    private BottomTabBar mTabBut;
    private ListView mLv;
    private ImageView mBianji;
    private ImageView mPic;
    private SlidingMenu mZid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐层App标题栏
        getSupportActionBar().hide();
        initData();
        initView();
    }

    protected void initData() {
        img = new ArrayList<>();
        tv_list = new ArrayList<>();
        img.add(R.mipmap.guanzhu);
        img.add(R.mipmap.shouceng);
        img.add(R.mipmap.sousuo);
        img.add(R.mipmap.xiaoxi);
        tv_list.add("我的关注");
        tv_list.add("我的收藏");
        tv_list.add("搜索好友");
        tv_list.add("消息通知");

    }

    protected void initView() {
        mText = (TextView) findViewById(R.id.text);
        mTabBut = (BottomTabBar) findViewById(R.id.tab_but);
        mLv = (ListView) findViewById(R.id.lv);
        mTabBut.init(getSupportFragmentManager())
                .setImgSize(80, 80)
                .setFontSize(15)
                .setChangeColor(Color.CYAN, Color.GRAY)
                .addTabItem("推荐", R.mipmap.recommend, R.mipmap.recommend1, Recommend_frag.class)
                .addTabItem("段子", R.mipmap.cross_talk, R.mipmap.cross_talk1, Cross_talk_frag.class)
                .addTabItem("视频", R.mipmap.video, R.mipmap.video1, Video_frag.class)
                .isShowDivider(false);

        MyListAdapter adapter = new MyListAdapter(this, img, tv_list);
        mLv.setAdapter(adapter);
        mTabBut.setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
            @Override
            public void onTabChange(int position, String name) {
                mText.setText(name);
                Toast.makeText(MainActivity.this, "====" + position + "===" + name, Toast.LENGTH_SHORT).show();
            }
        });


        mBianji = (ImageView) findViewById(R.id.bianji);
        mBianji.setOnClickListener(this);
        mPic = (ImageView) findViewById(R.id.pic);
        mPic.setOnClickListener(this);
        mZid = (SlidingMenu) findViewById(R.id.zid);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bianji:
                break;
            case R.id.pic:
                mZid.toggle();
                break;
        }
    }
}
