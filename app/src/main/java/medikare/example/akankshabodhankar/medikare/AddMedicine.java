package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by akanksha bodhankar on 08-12-2015.
 */
public class AddMedicine extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmedicine);
        TextView tv = new TextView(this);
        tv.setText("Add medicine");
    }
}
