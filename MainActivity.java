package com.example.app.beamanalysis;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    TextView btext;
    TextView htext;
    TextView dtext;
    TextView fctext;
    TextView fytext;
    TextView astext;
    EditText editb;
    EditText edith;
    EditText editd;
    EditText editfc;
    EditText editfy;
    EditText editas;
    Button myButton;

    TextView atext;
    TextView ctext;
    TextView ettext;
    TextView phitext;
    TextView mntext;
    TextView phimntext;
    EditText edita;
    EditText editc;
    EditText editet;
    EditText editmn;
    EditText editphimn;

    double b, h, d, fc, fy, as = 0.0;
    double aVal, cVal, etVal, mnVal, phimnVal = 0.0;
    String aStr, cStr, etStr, mnStr, phimnStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		// Initialize the GUI
        btext = (TextView) findViewById(R.id.textView_b);
        htext = (TextView) findViewById(R.id.textView_h);
        dtext = (TextView) findViewById(R.id.textView_d);
        fctext = (TextView) findViewById(R.id.textView_fc);
        fytext = (TextView) findViewById(R.id.textView_fy);
        astext = (TextView) findViewById(R.id.textView_As);
        editb = (EditText) findViewById(R.id.editText_b);
        edith = (EditText) findViewById(R.id.editText_h);
        editd = (EditText) findViewById(R.id.editText_d);
        editfc = (EditText) findViewById(R.id.editText_fc);
        editfy = (EditText) findViewById(R.id.editText_fy);
        editas = (EditText) findViewById(R.id.editText_As);
        myButton = (Button) findViewById(R.id.calc_button);

        atext = (TextView) findViewById(R.id.textView_a);
        ctext = (TextView) findViewById(R.id.textView_c);
        ettext = (TextView) findViewById(R.id.textView_et);
        phitext = (TextView) findViewById(R.id.textView_phi);
        mntext = (TextView) findViewById(R.id.textView_mn);
        phimntext = (TextView) findViewById(R.id.textView_phimn);
        edita = (EditText) findViewById(R.id.editText_a);
        editc = (EditText) findViewById(R.id.editText_c);
        editet = (EditText) findViewById(R.id.editText_et);
        editmn = (EditText) findViewById(R.id.editText_mn);
        editphimn = (EditText) findViewById(R.id.editText_phimn);

		/*
			When the "Calculate" button is clicked,
			calculate all the results given the user input
			then display the results on the GUI
		*/
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				// Get input values
                b = Double.parseDouble(editb.getText().toString());
                h = Double.parseDouble(edith.getText().toString());
                d = Double.parseDouble(editd.getText().toString());
                fc = Double.parseDouble(editfc.getText().toString());
                fy = Double.parseDouble(editfy.getText().toString());
                as = Double.parseDouble(editas.getText().toString());

				// These are the equations used to calculate the results 
                aVal = ((as*fy)/(0.85*fc*b));
                cVal = (aVal/0.85);
                etVal = (((d-cVal)/cVal)*(0.003));
                mnVal = ((as*fy*(d-(aVal/2.0)))/12.0);
                phimnVal = (0.9*mnVal);

				// Use BigDecimal class to accurately round to 4 decimal places
                aStr = new BigDecimal(String.valueOf(aVal)).setScale(4, BigDecimal.ROUND_HALF_UP).toPlainString();
                cStr = new BigDecimal(String.valueOf(cVal)).setScale(4, BigDecimal.ROUND_HALF_UP).toPlainString();
                etStr = new BigDecimal(String.valueOf(etVal)).setScale(4, BigDecimal.ROUND_HALF_UP).toPlainString();
                mnStr = new BigDecimal(String.valueOf(mnVal)).setScale(4, BigDecimal.ROUND_HALF_UP).toPlainString();
                phimnStr = new BigDecimal(String.valueOf(phimnVal)).setScale(4, BigDecimal.ROUND_HALF_UP).toPlainString();

				// Display the results
                edita.setText(aStr, TextView.BufferType.EDITABLE);
                editc.setText(cStr, TextView.BufferType.EDITABLE);
                editet.setText(etStr, TextView.BufferType.EDITABLE);
                editmn.setText(mnStr, TextView.BufferType.EDITABLE);
                editphimn.setText(phimnStr, TextView.BufferType.EDITABLE);

            }
        });
    }
}
