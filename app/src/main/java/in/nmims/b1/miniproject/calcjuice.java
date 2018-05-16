package in.nmims.b1.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Aditya on 3/5/2018.
 */

public class calcjuice extends AppCompatActivity {
    Spinner size;
    EditText qty;
    CheckBox sugar;
    CheckBox cc;
    CheckBox wc;
    Button order,clear;
    double no,m=0,amt,base=100;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcjuice);
        size = (Spinner) findViewById(R.id.spinner);
        qty = (EditText) findViewById(R.id.editText);
        sugar=(CheckBox)findViewById(R.id.checkBox);
        cc=(CheckBox)findViewById(R.id.checkBox2);
        wc=(CheckBox)findViewById(R.id.checkBox3);
        order=(Button)findViewById(R.id.button);
        clear=(Button)findViewById(R.id.button5);
        clear.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                                 qty.setText("");
                                 sugar.setChecked(false);
                                 cc.setChecked(false);
                                 wc.setChecked(false);
                             }
                         }
);
        size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type=size.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type.equals("Cup")){
                    base=base-50;
                }
                else if(type.equals("500mL Bottle")){
                    base=base+0;
                }
                else if(type.equals("1L Bottle")){
                    base=base+50;
                }
                no=Double.parseDouble(qty.getText().toString());
                amt=base*no;
                if(sugar.isChecked()){
                    amt=amt+10;
                }
                if(cc.isChecked()){
                    amt=amt+10;
                }
                if(wc.isChecked()){
                    amt=amt+10;
                }
                Intent in=new Intent(calcjuice.this,End_Page.class);
                in.putExtra("amount",String.valueOf(amt));
                startActivity(in);
                //Toast.makeText(cappucino.this,String.valueOf(amt),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
