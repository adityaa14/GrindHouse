
package in.nmims.b1.miniproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static in.nmims.b1.miniproject.R.layout.activity_end__page;


public class End_Page extends AppCompatActivity {
    EditText am;
    Button prev,cancel,pay,help;
    Double amt=0.0,finalamt=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_end__page);
        Intent in=getIntent();
        help=(Button)findViewById(R.id.button3);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent in=new Intent(End_Page.this,HelpSupport.class);
startActivity(in);
            }
        });
        final String amount=in.getStringExtra("amount");
        am=(EditText)findViewById(R.id.editText2);
        try{
            String query="select amount from amount";
            SQLiteDatabase db=openOrCreateDatabase("cart",MODE_PRIVATE,null);
            Cursor c=db.rawQuery(query,null);
            if(c.moveToFirst()){
                do{
                    amt = amt + Double.parseDouble(c.getString(0));
                }while (c.moveToNext());
            }
        }catch (Exception e){

        }
        finalamt=amt+Double.parseDouble(amount);
        am.setText(String.valueOf(finalamt));
        prev=(Button)findViewById(R.id.button2);
        prev.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        SQLiteDatabase db=openOrCreateDatabase("cart",MODE_PRIVATE,null);
                                        db.execSQL("create table if not exists amount(amount varchar)");
                                        db.execSQL("insert into amount values('"+amount+"')");
                                        Intent in=new Intent(End_Page.this,linker.class);
                                        startActivity(in);
                                    }
                                }
        );
        cancel=(Button)findViewById(R.id.button4);
        cancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                       am.setText("");
                                        String query="delete from amount";
                                        SQLiteDatabase db=openOrCreateDatabase("cart",MODE_PRIVATE,null);
                                        db.execSQL(query);
                                        Toast.makeText(End_Page.this,"Your Order has been cancelled",Toast.LENGTH_SHORT).show();
                                        Intent in=new Intent(End_Page.this,linker.class);
                                        startActivity(in);
                                    }
                                }
        );
        pay=(Button)findViewById(R.id.button5);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query="delete from amount";
                SQLiteDatabase db=openOrCreateDatabase("cart",MODE_PRIVATE,null);
                db.execSQL(query);
                Toast.makeText(End_Page.this,"Please pay amount to the cashier",Toast.LENGTH_SHORT).show();
            }
        });
    }
}