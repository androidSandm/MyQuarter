package com.example.mybase.presenter;

import com.example.mybase.model.BaseModel;
import com.example.mybase.view.inter.IBaseView;

/**
 * Created by BoyLucky on 2018/7/17.
 */

public class BasePresenter <M extends BaseModel,V extends IBaseView> implements IBasePresenter{
    public M model;
    public V view;
    /*
    绑定view和model
     */
    public void attch(M m,V v) {
        this.model = m;
        this.view = v;
    }

    /*
    回收资源，解绑，避免内存泄漏
     */
    public void detach(){
        this.model = null;
        this.view = null;
    }
}