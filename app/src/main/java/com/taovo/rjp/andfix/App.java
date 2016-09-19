package com.taovo.rjp.andfix;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;
import java.io.IOException;

/**
 * @Author：RJP on 2016/9/19 18:33
 */
public class App extends Application {
    private PatchManager patchManager;

    @Override
    public void onCreate() {
        super.onCreate();

        patchManager = new PatchManager(getApplicationContext());
        patchManager.init(getVersionCode() + "");//current version
        patchManager.loadPatch();
        try {
            patchManager.addPatch(Environment.getExternalStorageDirectory() + File.separator + "andfix" + File.separator + "patch.apatch");//path of the patch file that was downloaded
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取版本号
     *
     * @return
     */
    public int getVersionCode() {
        PackageManager packageManager = this.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }
}
