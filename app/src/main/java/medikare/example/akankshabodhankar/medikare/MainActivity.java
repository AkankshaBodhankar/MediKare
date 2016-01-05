package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    DBAdapter mydb;
    TextView addmedicine_tv;
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

        addmedicine_tv=(TextView)findViewById(R.id.addmedicine_tv);

        addmedicine_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddMedicine.class);
                startActivity(i);

            }
        });

        openDB();
//        populateListView();
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        closeDB();
    }

    private void openDB()
    {
        mydb= new DBAdapter(this);
        mydb.open();
    }

    private void closeDB()
    {
        mydb.close();
    }

    public void onClick_ClearAll(View v)
    {
        mydb.deleteAll();
        populateListViewFromDB();
    }

    private void populateListViewFromDB() {
        Cursor cursor = mydb.getAllRows();

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
        ListView myList = (ListView)findViewById(R.id.list);
        myList.setAdapter(myCursorAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
       /* if(id==R.id.action_settings)
        {
            //intent to settings page
        }*/
        if(id==R.id.navigate)
        {
            startActivity(new Intent(this,AddMedicine.class));
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void populateListView()
    {
        Cursor cursor = mydb.getAllRows();
        String[] fromFieldNames = new String[] {DBAdapter.KEY_ROWID,DBAdapter.KEY_NAME,DBAdapter.KEY_TIME};
        int[] toViewIDs = new int[]{R.id.item_name_tv,R.id.item_purpose_tv,R.id.item_time_tv};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.item_layout,cursor,fromFieldNames,toViewIDs,0);
        ListView mylist = (ListView)findViewById(R.id.list);
        mylist.setAdapter(myCursorAdapter);

    }




}
