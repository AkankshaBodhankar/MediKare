package medikare.example.akankshabodhankar.medikare;

/**
 * Created by akanksha bodhankar on 04-03-2016.
 */
public final class MedicineContract {

    MedicineContract()
    {

    }
    public static abstract class MedicineEntry
    {
        public static final String ID = "id";
        public static final String Name = "name";
        public static final String Time = "time";
        public static final String Dosage = "dosage";
        public  static final String Purpose = "purpose";
        public static final String TABLE_NAME = "medicine_table";

    }
}
