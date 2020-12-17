package com.example.dayo;

public class HomeForPecese {
    private final HomeForMo1 mo1;
    private IView mView;

    public HomeForPecese(IView mView) {
        this.mView = mView;
        mo1 = new HomeForMo1();
    }
    public void start(){
        mo1.request(new RequestCallBack() {
            @Override
            public void showsudsdh(Object object) {
                mView.sudshd(object);
            }

            @Override
            public void showfishd(String msg) {
                mView.fisjd(msg);
            }
        });
    }
}
