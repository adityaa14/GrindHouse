package in.nmims.b1.miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class coffee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee);
        ImageButton capp = (ImageButton)findViewById(R.id.imageButton);
        ImageButton cold = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton expresso = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton latte = (ImageButton)findViewById(R.id.imageButton4);
        Button back=(Button)findViewById((R.id.button6));

        capp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // use Intent

                Intent intent1= new Intent(coffee.this, cappucino.class);
                startActivity(intent1);
    }
});
        cold.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // use Intent

                Intent intent1= new Intent(coffee.this, cappucino.class);
                startActivity(intent1);
            }
        });
        expresso.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // use Intent

                Intent intent1= new Intent(coffee.this, cappucino.class);
                startActivity(intent1);
            }
        });
        latte.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // use Intent

                Intent intent1= new Intent(coffee.this, cappucino.class);
                startActivity(intent1);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // use Intent

                Intent intent1= new Intent(coffee.this, linker.class);
                startActivity(intent1);
            }
        });
}
}