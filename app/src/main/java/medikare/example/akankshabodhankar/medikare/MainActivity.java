package medikare.example.akankshabodhankar.medikare;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    CustomDrawerAdapter adapter;

    List<DrawerItem> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = new ArrayList<DrawerItem>();
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.mipmap.drawer_shadow,
                GravityCompat.START);
        dataList.add(new DrawerItem("Today's Medicines", R.mipmap.ic_capsule));
        dataList.add(new DrawerItem("ViewDetails", R.mipmap.ic_view_details));
        dataList.add(new DrawerItem("ViewHistory", R.mipmap.ic_view_details));
        adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
                dataList);

        mDrawerList.setAdapter(adapter);



    }
    public void SelectItem(int possition) {

        Fragment fragment = null;
        Bundle args = new Bundle();
        switch (possition) {
            case 0:
                fragment = new AddMedicine();
                args.putString(AddMedicine.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(AddMedicine.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 1:
                fragment = new ViewHistory();
                args.putString(ViewHistory.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(ViewHistory.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 2:
                fragment = new ViewDetails();
                args.putString(ViewDetails.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(ViewDetails.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 3:
                fragment = new AddMedicine();
                args.putString(AddMedicine.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(AddMedicine.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 4:
                fragment = new ViewHistory();
                args.putString(ViewHistory.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(ViewHistory.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 5:
                fragment = new ViewDetails();
                args.putString(ViewDetails.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(ViewDetails.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 6:
                fragment = new AddMedicine();
                args.putString(AddMedicine.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(AddMedicine.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 7:
                fragment = new ViewHistory();
                args.putString(ViewHistory.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(ViewHistory.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 8:
                fragment = new ViewDetails();
                args.putString(ViewDetails.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(ViewDetails.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 9:
                fragment = new AddMedicine();
                args.putString(AddMedicine.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(AddMedicine.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 10:
                fragment = new ViewHistory();
                args.putString(ViewHistory.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(ViewHistory.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 11:
                fragment = new ViewDetails();
                args.putString(ViewDetails.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(ViewDetails.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 12:
                fragment = new AddMedicine();
                args.putString(AddMedicine.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(AddMedicine.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            default:
                break;
        }

        fragment.setArguments(args);
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                .commit();

        mDrawerList.setItemChecked(possition, true);
        setTitle(dataList.get(possition).getItemName());
        mDrawerLayout.closeDrawer(mDrawerList);

    }
}
