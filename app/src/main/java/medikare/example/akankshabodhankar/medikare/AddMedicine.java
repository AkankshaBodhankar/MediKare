package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by akanksha bodhankar on 08-12-2015.
 */
public class AddMedicine extends Activity{
    Button bt_submit,bt_picktime;
    Calendar calendar = Calendar.getInstance();
    static final int dialog_id=0;//to get appropriate dialog
    int hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmedicine);
       // bt_picktime = (Button)findViewById(R.id.picktime_button);
        showTimePickerDialog();
       /*dbhelper dbh = new dbhelper(this,"MediKare.db",null,1);
        db = dbh.getWritableDatabase();*/

    }
    public void showTimePickerDialog()
    {
       // bt_submit = (Button)findViewById(R.id.picktime_button);
        bt_submit.setOnClickListener(new View.OnClickListener() {
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
                    bt_picktime.setText("Choosen time is:"+hour+":"+hour_minute);

                }
            };
}
