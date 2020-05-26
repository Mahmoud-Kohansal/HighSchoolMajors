package ir.medu.khn.highschoolmajors;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SchoolsActivity extends AppCompatActivity implements SchoolFilterDialog.SchoolFilterDialogListener{

    RecyclerView mSchools_RecyclerView;
    LinearLayoutManager mSchoolsRcVw_LayoutManager;
    SchoolsRcVwAdapter mSchoolsRcVw_Adapter;
    ArrayList<SchoolInfoItem> schoolInfoItems_List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);
        setTitle("هنرستان ها");
        //Define view objects
        defineObjects();
        //Draw Menu
        makeList();
        buildRecyclerView();
    }
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater schoolsMenuInflator = getMenuInflater();
        schoolsMenuInflator.inflate(R.menu.schools_menu,menu);

        MenuItem search_MnuItem = menu.findItem(R.id.search_SchoolsMnuItm);
        SearchView searchView = (SearchView) search_MnuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        MenuItem filter_MnuItem = menu.findItem(R.id.filter_SchoolsMnuItm);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String queryText) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String queryText) {
                mSchoolsRcVw_Adapter.getFilter().filter(queryText);
                return false;
            }
        });


        filter_MnuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.filter_SchoolsMnuItm)
                {
                    openSchoolFilterDialog();
                }
                return false;
            }
        });
        return true;
    }

    private void defineObjects() {
        mSchools_RecyclerView = findViewById(R.id.schoolsItems_RcVw);

    }

    private void buildRecyclerView()
    {        
        mSchools_RecyclerView.setHasFixedSize(true);
        mSchoolsRcVw_LayoutManager = new LinearLayoutManager(this);
        mSchoolsRcVw_Adapter = new SchoolsRcVwAdapter(schoolInfoItems_List);
        mSchools_RecyclerView.setLayoutManager(mSchoolsRcVw_LayoutManager);
        mSchools_RecyclerView.setAdapter(mSchoolsRcVw_Adapter);
    }
    private void makeList()
    {
        schoolInfoItems_List = new ArrayList<>();
        schoolInfoItems_List.add(new SchoolInfoItem("اسفراین","طالقانی",R.drawable.agri1,"کامپیوتر - معماری - تربیت بدنی - حسابداری","انتهای خیابان امام رضا"));
        schoolInfoItems_List.add(new SchoolInfoItem("اسفراین","طالقانی",R.drawable.agri1,"کامپیوتر - معماری - تربیت بدنی - حسابداری","انتهای خیابان امام رضا"));
        schoolInfoItems_List.add(new SchoolInfoItem("اسفراین","طالقانی",R.drawable.agri1,"کامپیوتر - معماری - تربیت بدنی - حسابداری","انتهای خیابان امام رضا"));

    }

    private void openSchoolFilterDialog()
    {
        SchoolFilterDialog schoolFilterDialog = new SchoolFilterDialog();
        schoolFilterDialog.show(getSupportFragmentManager(),"School Filter Dialog");

    }
    @Override
    public void applyTexts(String username, String password) {
        Toast.makeText(getApplicationContext(),username + "" +password,Toast.LENGTH_LONG).show();
    }
    
    public String readJSON(String fileNameInAssets) {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = getAssets().open(fileNameInAssets);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }
}
