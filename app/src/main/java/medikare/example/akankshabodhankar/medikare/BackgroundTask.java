package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by akanksha bodhankar on 04-03-2016.
 */
public class BackgroundTask extends AsyncTask<String,Medicine,String> {

    Context ctx;
    MedicineAdapter medicineAdapter;
    Activity activity;
    ListView listView;
    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
        activity = (Activity)ctx;

    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        DbOperations dbOperations = new DbOperations(ctx);

        if(method.equals("add_info"))
        {
            int id = Integer.parseInt(params[1]);
            String name = params[2];
            String time = params[3];
            int dosage = Integer.parseInt(params[4]);
            String purpose = params[5];
            SQLiteDatabase db = dbOperations.getWritableDatabase();
            dbOperations.addInformations(db,id,name,time,dosage,purpose);
            return "Medicine Inserted";
        }
        else if(method.equals("get_info"))
        {
            listView = (ListView)activity.findViewById(R.id.list_medicines);
            SQLiteDatabase db = dbOperations.getReadableDatabase();
            Cursor cursor = dbOperations.getInformations(db);
            medicineAdapter = new MedicineAdapter(ctx,R.layout.item_layout);
            int id,dosage;
            String purpose,name,time;
            while(cursor.moveToNext())
            {
                id = cursor.getInt(cursor.getColumnIndex(MedicineContract.MedicineEntry.ID));
                name = cursor.getString(cursor.getColumnIndex(MedicineContract.MedicineEntry.Name));
                time = cursor.getString(cursor.getColumnIndex(MedicineContract.MedicineEntry.Time));
                dosage = cursor.getInt(cursor.getColumnIndex(MedicineContract.MedicineEntry.Dosage));
                purpose = cursor.getString(cursor.getColumnIndex(MedicineContract.MedicineEntry.Purpose));
                Medicine medicine = new Medicine(id,name,time,dosage,purpose);
                publishProgress(medicine);

            }
             return "get_info";

        }
        return null;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Medicine... values) {

        medicineAdapter.add(values[0]);


    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("get_info"))
        {
            listView.setAdapter(medicineAdapter);
        }
        else
          Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
