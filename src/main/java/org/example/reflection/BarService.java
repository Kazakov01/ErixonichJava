package org.example.reflection;

public class BarService implements Notifiable{

    @Override
    @LogAnno(lvl = "info")
    public void customNotify() {
        System.out.println("BarService::customNotify");
    }

}
