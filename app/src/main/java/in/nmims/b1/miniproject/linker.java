package in.nmims.b1.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class linker extends AppCompatActivity {


    Button cof,tea,juice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linker);


        cof=findViewById(R.id.cof);
        tea=findViewById(R.id.tea);
        juice=findViewById(R.id.juice);


        cof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1= new Intent(getApplicationContext(), coffee.class);
                startActivity(intent1);
            }
        });
        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1= new Intent(getApplicationContext(), tea.class);
                startActivity(intent1);
            }
        });
        juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1= new Intent(getApplicationContext(), juice.class);
                startActivity(intent1);
            }
        });




    }
}