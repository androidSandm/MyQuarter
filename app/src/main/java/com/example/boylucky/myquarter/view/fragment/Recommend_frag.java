package com.example.boylucky.myquarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.boylucky.myquarter.R;
import com.example.mybase.model.BaseModel;
import com.example.mybase.presenter.BasePresenter;
import com.example.mybase.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by BoyLucky on 2018/7/20.
 */

public class Recommend_frag extends BaseFragment {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private View view;
    private Unbinder unbinder;
    private String[] mTabTitles = {"热门","关注"};
    private List<Fragment> list_frag;
    @Override
    protected void initView() {
        list_frag = new ArrayList<>();
        list_frag.add(new Remen_frag());
        list_frag.add(new Guanzhu_frag());
        for (int i = 0; i < mTabTitles.length; i++) {
            tab.addTab(tab.newTab().setText(mTabTitles[i]));
        }
        MVpAdapter mVpAdapter = new MVpAdapter(getFragmentManager(), list_frag);
        vp.setAdapter(mVpAdapter);
        tab.setupWithViewPager(vp);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BaseModel initModel() {
        return null;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.recommend_frag;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public class MVpAdapter extends FragmentPagerAdapter {
        List<Fragment> list;
        public MVpAdapter(FragmentManager fm, List<Fragment> list ) {
            super(fm);
            this.list = list;
        }
        public MVpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position < list.size()) {
                fragment = list.get(position);
            } else {
                fragment = list.get(0);
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            if (mTabTitles != null && mTabTitles.length > 0){
                return mTabTitles[position];
            }
            return null;
        }
    }
}
