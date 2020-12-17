package com.example.dayo;

import com.example.dayo.bean.JavaBean;
import com.example.dayo.bean.ShiBean;
import com.example.dayo.bean.ShoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String tu="http://123.56.232.18:8080/";
    String shi="http://123.56.232.18:8080/";
    String cang="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<JavaBean> getData();
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<ShiBean> getShi();
    @GET("serverdemo//tag/queryTagList")
    Observable<ShoBean> getCang();
}
