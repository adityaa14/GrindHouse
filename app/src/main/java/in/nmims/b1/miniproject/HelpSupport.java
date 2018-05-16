package in.nmims.b1.miniproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelpSupport extends AppCompatActivity {
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_support);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query="delete from amount";
                SQLiteDatabase db=openOrCreateDatabase("cart",MODE_PRIVATE,null);
                db.execSQL(query);
                Toast.makeText(HelpSupport.this,"Our Customer Service Executive will get back to you shortly!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}