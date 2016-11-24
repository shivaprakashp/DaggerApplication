package talents.daggerapplication;

import android.app.Application;
import android.content.Context;

import talents.daggerapplication.daggerclasses.DaggerElectricBill;
import talents.daggerapplication.daggerclasses.ElectricBill;
import talents.daggerapplication.daggerclasses.ElectricModule;

/**
 * Created by 19569 on 11/23/2016.
 */

public class MainApplication extends Application {

    private static ElectricBill electricBill;

    @Override
    public void onCreate() {
        super.onCreate();

        electricBill = DaggerElectricBill.builder().electricModule(new ElectricModule()).build();

    }

    public static ElectricBill getComponent(){
        return electricBill;
    }
}
