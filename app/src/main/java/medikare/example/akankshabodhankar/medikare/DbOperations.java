package medikare.example.akankshabodhankar.medikare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by akanksha bodhankar on 04-03-2016.
 */
public class DbOperations extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "medicines_info.db";

    private static final String CREATE_QUERY="create table "+MedicineContract.MedicineEntry.TABLE_NAME+
            "("+ MedicineContract.MedicineEntry.ID+" integer,"+MedicineContract.MedicineEntry.Name+" text,"+MedicineContract.MedicineEntry.Time+" text,"+
            MedicineContract.MedicineEntry.Dosage+" integer,"+ MedicineContract.MedicineEntry.Purpose+" text);";

    public DbOperations(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("Database operations","Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.d("Database Operations","Table Created");

    }
    public void addInformations(SQLiteDatabase db,int id,String name,String time,int dosage,String purpose)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MedicineContract.MedicineEntry.ID,id);
        contentValues.put(MedicineContract.MedicineEntry.Name,name);
        contentValues.put(MedicineContract.MedicineEntry.Time,time);
        contentValues.put(MedicineContract.MedicineEntry.Dosage,dosage);
        contentValues.put(MedicineContract.MedicineEntry.Purpose, purpose);

        db.insert(MedicineContract.MedicineEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operations", "One Row inserted");
    }
    public Cursor getInformations(SQLiteDatabase db)
    {
        String[] projections = {MedicineContract.MedicineEntry.ID, MedicineContract.MedicineEntry.Name, MedicineContract.MedicineEntry.Time,
                MedicineContract.MedicineEntry.Dosage, MedicineContract.MedicineEntry.Purpose};
        Cursor cursor  = db.query(MedicineContract.MedicineEntry.TABLE_NAME,projections,null,null,null,null,null,null);

        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
