package com.example.mybase.view.inter;

public interface IBaseView {
    void showLoading();
    void hideLoading();

    void serverFail(String msg);
}
