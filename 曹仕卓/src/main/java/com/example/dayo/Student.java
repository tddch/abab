package com.example.dayo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id(autoincrement = true)
    private Long mid;
    private String img;
    private String tvs;
    private String tvse;
    @Generated(hash = 628099097)
    public Student(Long mid, String img, String tvs, String tvse) {
        this.mid = mid;
        this.img = img;
        this.tvs = tvs;
        this.tvse = tvse;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getMid() {
        return this.mid;
    }
    public void setMid(Long mid) {
        this.mid = mid;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getTvs() {
        return this.tvs;
    }
    public void setTvs(String tvs) {
        this.tvs = tvs;
    }
    public String getTvse() {
        return this.tvse;
    }
    public void setTvse(String tvse) {
        this.tvse = tvse;
    }
    
}
