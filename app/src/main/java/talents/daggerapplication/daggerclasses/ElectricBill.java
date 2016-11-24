package talents.daggerapplication.daggerclasses;

import dagger.Component;
import talents.daggerapplication.MainActivity;

/**
 * Created by 19569 on 11/23/2016.
 */
@Component (modules = {ElectricModule.class})
public interface ElectricBill {
    public void inject(MainActivity mainActivity);
}
