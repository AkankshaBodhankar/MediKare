package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by akanksha bodhankar on 08-12-2015.
 */
public class AddMedicine extends Activity{
    Button bt;
    TextView tv;
    Calendar calendar = Calendar.getInstance();
    static final int dialog_id=0;//to get appropriate dialog
    int hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmedicine);
        tv = (TextView)findViewById(R.id.starttime);
        showTimePickerDialog();

    }
    public void showTimePickerDialog()
    {
        bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new TimePickerDialog(AddMedicine.this,onTimeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show();
            }
        });
    }
     TimePickerDialog.OnTimeSetListener onTimeSetListener=
             new TimePickerDialog.OnTimeSetListener() {
                 @Override
                 public void onTimeSet(TimePicker view, int hourOfDay, int hour_minute) {
                     hour = hourOfDay;
                     minute = hour_minute;
                     tv.setText("Choosen time is:"+hour+":"+hour_minute);

                 }
             };
}
