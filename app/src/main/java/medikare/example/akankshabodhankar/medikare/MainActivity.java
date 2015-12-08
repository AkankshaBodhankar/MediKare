package medikare.example.akankshabodhankar.medikare;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TabHost;


public class MainActivity extends TabActivity {
    private TabHost mTabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;
        //Add medicine
        intent = new Intent(this,AddMedicine.class);
        spec = mTabHost.newTabSpec("AddReminder")
                .setIndicator("AddReminder", getResources().getDrawable(R.drawable.add))
                .setContent(intent);
        mTabHost.addTab(spec);
        Resources res = getResources();
        //ViewHistory
        intent = new Intent(this,ViewHistory.class);
        spec = mTabHost.newTabSpec("ViewHistory")
                .setIndicator("ViewHistory",getResources().getDrawable(R.drawable.capsule))
                .setContent(intent);
        mTabHost.addTab(spec);
        //ViewDetails
        intent = new Intent(this,ViewDetails.class);
        spec = mTabHost.newTabSpec("ViewDetails")
                .setIndicator("ViewDetails")
                .setContent(intent);
        mTabHost.addTab(spec);

        mTabHost.setCurrentTab(2);



    }
}
