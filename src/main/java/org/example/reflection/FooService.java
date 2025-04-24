package org.example.reflection;

public class FooService implements Notifiable{

    @Override
    @LogAnno(lvl = "warning")
    public void customNotify() {
        System.out.println("FooService::customNotify");
    }



}
