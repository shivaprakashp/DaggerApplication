package talents.daggerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import javax.inject.Inject;

import talents.daggerapplication.daggerclasses.ElectricModule;
import talents.daggerapplication.modules.CommercialPlan;
import talents.daggerapplication.modules.DomesticPlan;
import talents.daggerapplication.modules.ElectricPlan;

public class MainActivity extends AppCompatActivity {

    private String[] elecType = { "Domestic", "Commercial"};
    private Spinner elecTypeSpinner;
    private String planType;
    private TextView totBill;
    private EditText unit_no;

    @Inject
    DomesticPlan domesticPlan;

    @Inject
    CommercialPlan commercialPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApplication.getComponent().inject(this);

        initView();

    }

    private void initView(){
        totBill = (TextView) findViewById(R.id.tot_bill);
        unit_no = (EditText) findViewById(R.id.unit_no);
        findViewById(R.id.btn_submit).setOnClickListener(generateBill);

        elecTypeSpinner = (Spinner) findViewById(R.id.electricity_type);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, elecType);
        elecTypeSpinner.setAdapter(arrayAdapter);

        elecTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                elecTypeSpinner.setSelection(position);
                planType = (String)elecTypeSpinner.getSelectedItem();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private View.OnClickListener generateBill = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        switch (planType){

            case "Domestic":

                domesticPlan.getRate();
                totBill.setText("Bill amount of Domestic plan "+unit_no.getText()+" unit is : "+
                String.valueOf(domesticPlan.calculateBill(Integer.parseInt(unit_no.getText().toString()))));

                break;

            case "Commercial":

                commercialPlan.getRate();
                totBill.setText("Bill amount of Commercial plan "+unit_no.getText()+" unit is : "+
                        String.valueOf(commercialPlan.calculateBill(Integer.parseInt(unit_no.getText().toString()))));

                break;

            default:

                break;
        }
        }
    };
}
