package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class WeakSoftReferences {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<String> weakReference = new WeakReference<>(new String("User"));
        String user = weakReference.get();

        SoftReference<String> softReference = new SoftReference<>(new String("Student"));
        String student = softReference.get();

        WeakReference<User> weakUser = new WeakReference<>(new User(2, "Vasya"));
        User userVasya = weakUser.get();

        System.gc();
        TimeUnit.SECONDS.sleep(3);

        userVasya.setAge(3);
        weakUser.get().setAge(5);
        System.out.println(weakUser.get().getAge());
    }
}
