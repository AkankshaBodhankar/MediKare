package medikare.example.akankshabodhankar.medikare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by akanksha bodhankar on 04-03-2016.
 */
public class MedicineAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public MedicineAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Medicine object)
    {
        list.add(object);
        super.add(object);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MedicineHolder medicineHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.item_layout,parent,false);
            medicineHolder = new MedicineHolder();
            medicineHolder.id_tv = (TextView)row.findViewById(R.id.item_id_tv);
            medicineHolder.name_tv = (TextView)row.findViewById(R.id.item_name_tv);
            medicineHolder.time_tv = (TextView)row.findViewById(R.id.item_time_tv);
            medicineHolder.dosage_tv = (TextView)row.findViewById(R.id.item_dosage_tv);
            medicineHolder.purpose_tv = (TextView)row.findViewById(R.id.item_purpose_tv);
            row.setTag(medicineHolder);


        }
        else
        {
            medicineHolder = (MedicineHolder)row.getTag();
        }
        Medicine medicine = (Medicine)getItem(position);
        medicineHolder.id_tv.setText(Integer.toString(medicine.getId()));
        medicineHolder.name_tv.setText(medicine.getName().toString());
        medicineHolder.time_tv.setText(medicine.getTime().toString());
        medicineHolder.dosage_tv.setText(Integer.toString(medicine.getDosage()));
        medicineHolder.purpose_tv.setText(medicine.getPurpose().toString());
        return row;

    }
    static class MedicineHolder
    {
        TextView id_tv,name_tv,time_tv,dosage_tv,purpose_tv;


    }
}
