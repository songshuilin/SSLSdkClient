package com.sslsdk.platform.mvp.login;

import android.content.Context;
import com.sslsdk.platform.domain.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/05/31--16:38
 */

public class LoginPresenterImpl implements  LoginPresenter{

    private LoginView view;
    private LoginInteractor loginInteractor;
    private Disposable fetchSubscription;

    public LoginPresenterImpl(Context context) {
        loginInteractor=new LoginInteractorImpl();
    }

    @Override
    public void setView(LoginView view) {
            this.view=view;
    }

    @Override
    public void destory() {
        view=null;
        hideLoading();
        if (fetchSubscription!=null && !fetchSubscription.isDisposed()){
            fetchSubscription.dispose();
        }
    }

    @Override
    public void login(String username, String password) {
        showLoading();
        fetchSubscription=loginInteractor.login(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoginSuccess,this::onLoginFailed);
    }


    private void showLoading(){
        if (isViewAttached()){
            view.showLoading();
        }
    }

    private void hideLoading(){
        view.hideLoading();
    }


    private boolean isViewAttached(){
        return view!=null;
    }


    private void onLoginSuccess(User user){
        if (isViewAttached()){
            view.loginSuccess(user);
        }
    }

    private void onLoginFailed(Throwable error){
        view.loginFail(error.toString());
    }

}
