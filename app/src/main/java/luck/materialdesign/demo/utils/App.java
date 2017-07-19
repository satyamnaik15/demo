package luck.materialdesign.demo.utils;

import android.app.Application;
import android.os.StrictMode;


/**
 * Created by satyam naik on 2016/07/18.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());


    }
}
