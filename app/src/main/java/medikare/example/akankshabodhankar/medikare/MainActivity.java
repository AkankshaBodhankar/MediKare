package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    DBAdapter myDB;
   /* int[] imageIDs= {
            R.drawable.capsule,
            R.drawable.capsule2,
            R.drawable.capsule3

    };*/
   // int nextImageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openDB();
        populateListViewFromDB();
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        closeDB();
    }

    private void openDB()
    {
        myDB= new DBAdapter(this);
        myDB.open();
    }

    private void closeDB()
    {
        myDB.close();
    }

    public void onClick_AddRecord(View v)
    {
        /*int imageid = imageIDs[nextImageIndex];
        nextImageIndex = (nextImageIndex+1)%imageIDs.length;*/

        //Add yo DB and redraw the Listview
        myDB.insertRow("Crocin",imageid, "Daily");
        populateListViewFromDB();
    }

    public void onClick_ClearAll(View v)
    {
        myDB.deleteAll();
        populateListViewFromDB();
    }

    private void populateListViewFromDB() {
        Cursor cursor = myDB.getAllRows();

        //Allow Activity to mange lifetime of cursor
        //DEPRECATED!
        startManagingCursor(cursor);

        //Set mapping from cursor to view fields
        String[] fromFieldNames = new String[]{DBAdapter.KEY_NAME,DBAdapter.KEY_TIME};
        int[] toViewIDs = new int[]{R.id.item_name_tv,R.id.item_icon};

        //create adapter to many columns of DB onto elemts of UI
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
                this,//context
                R.layout.item_layout, //Row Layout Template
                cursor,  //cursor (set of DB records to map)
                fromFieldNames, //DB column names
                toViewIDs //ViewIDs to put information in
        );

        //Set the adpter for ListView
        ListView myList = (ListView)findViewById(R.id.listView);
        myList.setAdapter(myCursorAdapter);
    }

}
