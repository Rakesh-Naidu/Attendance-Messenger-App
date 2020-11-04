package gitam.edu.cse.rn5023.attendance;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity{
    int n,ct=0,th=0;
    StringBuffer str=new StringBuffer(0);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ScrollView scrollView = new ScrollView(this);
        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(linearLayout);
        TextView t=new TextView(this);
        t.setText("Tick Absent Numbers");
        float v =35 ;
        t.setBackgroundColor(Color.YELLOW);
        t.setTextSize(v);
        t.setGravity(1);
        linearLayout.addView(t);
        this.setContentView(scrollView);
        final String a=getIntent().getStringExtra("hello");
        str.append(a);
        str.append("*Absent Roll Numbers:-* \n");
        String s1=getIntent().getStringExtra("hii");
        if(!s1.isEmpty())
        n=Integer.parseInt(s1);
        else
        {
            Toast.makeText(this, "Please Enter a Valid Number of Students", Toast.LENGTH_SHORT).show();
            finish();
        }
        if(n==0)
        {
            Toast.makeText(this, "Please Enter a Valid Number of Students", Toast.LENGTH_SHORT).show();
            finish();
        }
        for(int i=1;i<=n;i++) {
            CheckBox cb = new CheckBox(this);
            cb.setId(i);
            cb.setTextSize(20);
            cb.setText("     Roll No-" + i);
            linearLayout.addView(cb);
        }
        this.setContentView(scrollView);
        final Button b=new Button(this);
        int i1 = 0;
        b.setId(i1);
        b.setText("Finish");
        b.setTextSize(30);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct == 1) {
                    str.delete(0, str.length());
                    str.append(a);
                    str.append("*Absent Roll Numbers:-* \n");
                }
                th = 0;
                for (int i = 1; i <= n; i++) {
                    ct = 1;
                    CheckBox c = findViewById(i);
                    boolean checked = c.isChecked();
                    if (checked) {
                        str.append(i).append(",");
                        th = 1;
                    }
                }
                if (str.length() != 0)
                    str.deleteCharAt(str.length() - 1);
                if (th != 0) {
                   // Toast.makeText(Main2Activity.this, "" + str, Toast.LENGTH_SHORT).show();
                    send();
                }
                else {
                    str.append("\nNo Absentees");
                    //Toast.makeText(Main2Activity.this, "" + str, Toast.LENGTH_SHORT).show();
                    send();
                }
            }
            public void send() {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, ""+str);
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            }
        });
        linearLayout.addView(b);
        this.setContentView(scrollView);
    }
}
