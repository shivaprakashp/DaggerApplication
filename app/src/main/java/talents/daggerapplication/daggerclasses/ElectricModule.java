package talents.daggerapplication.daggerclasses;

import dagger.Module;
import dagger.Provides;
import talents.daggerapplication.modules.CommercialPlan;
import talents.daggerapplication.modules.DomesticPlan;

/**
 * Created by 19569 on 11/23/2016.
 */

@Module
public class ElectricModule {

    @Provides
    public DomesticPlan ProvideDomesticPlan(){
        return new DomesticPlan();
    }

    @Provides
    public CommercialPlan ProvideCommercialPlan(){
        return new CommercialPlan();
    }
}
