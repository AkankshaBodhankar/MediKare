package medikare.example.akankshabodhankar.medikare;

/**
 * Created by akanksha bodhankar on 11-12-2015.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class dbhelper extends SQLiteOpenHelper {

    public dbhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "create table medicine(name text,time text,int dose,int repeat);";
        db.execSQL(str);
    }

    @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String str = "drop table medicine";
        db.execSQL(str);
        onCreate(db);

    }
}
