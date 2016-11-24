package talents.daggerapplication.modules;

/**
 * Created by 19569 on 11/24/2016.
 */

public abstract class ElectricPlan {

    protected double rate;

    abstract void getRate();

    public double calculateBill(int units){
        return units*rate;
    }
}
