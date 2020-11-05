package gitam.edu.cse.rn5023.attendance;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    int flag = 2;
    String s1, s2,date;
    Calendar cal=Calendar.getInstance();
    public StringBuffer s = new StringBuffer();
    public EditText e1, e2;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.button);
        e1 = findViewById(R.id.edittext);
        e2 = findViewById(R.id.edittext1);
    }

    public void next(View view) {
        if(s.length()!=0)
            s.delete(0,s.length());
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        date=sdf.format(new Date());
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        s.append("Date :- ").append(date).append("\nSection :- ");
        s.append(s1).append(" \nStrength :- ");
        s.append(s2).append(" Students \n");
        if(flag==2)
            Toast.makeText(this,"Please Select One Option",Toast.LENGTH_SHORT).show();
        else if(flag==1)
        {
            Intent i=new Intent(MainActivity.this,Main2Activity.class);
            //Toast.makeText(this, ""+e2.getText(), Toast.LENGTH_SHORT).show();
            i.putExtra("hii",e2.getText().toString());
            String b=s.toString();
            i.putExtra("hello",b);
            //Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
     else if(flag==0)
        {
            Intent i2=new Intent(MainActivity.this,Main3Activity.class);
            i2.putExtra("hii",e2.getText().toString());
            String b=s.toString();
            i2.putExtra("hello",b);
            //Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
            startActivity(i2);
        }
    }

    public void change(View view) {
        flag=1;
    }

    public void rechange(View view) {
        flag=0;
    }
}
