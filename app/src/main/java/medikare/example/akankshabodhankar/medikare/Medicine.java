package medikare.example.akankshabodhankar.medikare;

/**
 * Created by akanksha bodhankar on 04-03-2016.
 */
public class Medicine {
    private String name,purpose,time;
    private int dosage,id;

    public Medicine(int id,String name,String time,int dosage,String purpose)
    {
        this.setId(id);
        this.setName(name);
        this.setTime(time);
        this.setDosage(dosage);
        this.setPurpose(purpose);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
