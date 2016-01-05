package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by akanksha bodhankar on 20-12-2015.
 */
public class AddMedicine extends Activity {

    //static SQLiteDatabase db= null;
    private DBAdapter mydb;
    EditText name_et,dosage_et,purpose_et;
    Button submit_bt;
    TextView timepicker_tv;
    String name,purpose,time,dosage;
    Calendar calendar = Calendar.getInstance();
    static final int dialog_id=0;//to get appropriate dialog
    int hour=0,minute=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmedicine);
        openDB();


        /*dbhelp dbh = new dbhelp(this, "Medikare.db", null, 1);//creating a database
        db = dbh.getWritableDatabase();*/

        timepicker_tv = (TextView)findViewById(R.id.timepicker_tv);

        submit_bt = (Button)findViewById(R.id.submit_bt);

        name_et = (EditText)findViewById(R.id.name_et);
        dosage_et = (EditText)findViewById(R.id.dosage_et);
        purpose_et = (EditText)findViewById(R.id.purpose_et);


        showTimePickerDialog();

        submit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // insert();
                OnClick_Add(v);

            }
        });
    }

   /* private void insert() {

        name = name_et.getText().toString();
        time = String.valueOf(hour+minute);
        dosage=dosage_et.getText().toString();
        purpose= purpose_et.getText().toString();


        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("time",time);
        cv.put("dosage", dosage);
        cv.put("purpose",purpose);
        long r = db.insert("medicines",null,cv);

        if(r==-1)
            Toast.makeText(getApplicationContext(), "Text not inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"Text inserted",Toast.LENGTH_LONG).show();


    }*/
    public void showTimePickerDialog()
    {
        // bt_submit = (Button)findViewById(R.id.picktime_button);
        timepicker_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(AddMedicine.this, onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
            }
        });
    }
    TimePickerDialog.OnTimeSetListener onTimeSetListener=
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int hour_minute) {
                    hour = hourOfDay;
                    minute = hour_minute;
                    timepicker_tv.setText(String.valueOf(hour) + ":" + String.valueOf(minute));

                }
            };
    private void openDB()
    {
        mydb = new DBAdapter(this);
        mydb.open();
    }
    public void OnClick_Add(View v)
    {
        if(name_et.getText().toString()!=" "&& timepicker_tv.getText().toString()!=" ")
        {
            Log.e("medicare", "add medicine  name =" + name_et.getText().toString() + " time =" + timepicker_tv.getText().toString() + " dosage=" + dosage_et.getText().toString() + " purpose=" + purpose_et.getText().toString());
            long r=mydb.insertRow(name_et.getText().toString(),timepicker_tv.getText().toString(),dosage_et.getText().toString(),purpose_et.getText().toString());
            if(r==-1)
                Toast.makeText(getApplicationContext(), "Text not inserted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Text inserted",Toast.LENGTH_LONG).show();
        }

    }

}
