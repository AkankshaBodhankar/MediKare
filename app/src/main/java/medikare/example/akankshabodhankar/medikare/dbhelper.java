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
        String str = "create table medicines(name text,time text,dosage text,purpose text);";
        db.execSQL(str);
    }

    @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String str = "drop table medicines";
        db.execSQL(str);
        onCreate(db);

    }
}
