package com.example.dayo;

import com.example.dayo.bean.JavaBean;
import com.example.dayo.bean.ShiBean;
import com.example.dayo.bean.ShoBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeForMo1 {
    public void request(final RequestCallBack callBack){
        new Retrofit.Builder()
                .baseUrl(ApiService.tu)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JavaBean javaBean) {
                        if(callBack!=null)
                            callBack.showsudsdh(javaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBack!=null)
                            callBack.showfishd(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        new Retrofit.Builder()
                .baseUrl(ApiService.shi)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getShi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShiBean shiBean) {
                        if(callBack!=null)
                            callBack.showsudsdh(shiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBack!=null)
                            callBack.showfishd(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        new Retrofit.Builder()
                .baseUrl(ApiService.cang)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getCang()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShoBean shoBean) {
                        if(callBack!=null)
                            callBack.showsudsdh(shoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBack!=null)
                            callBack.showfishd(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
