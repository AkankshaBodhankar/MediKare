package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by akanksha bodhankar on 08-12-2015.
 */
public class ViewHistory extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewhistory);
        TextView tv = new TextView(this);
        tv.setText("View History");
    }
}
