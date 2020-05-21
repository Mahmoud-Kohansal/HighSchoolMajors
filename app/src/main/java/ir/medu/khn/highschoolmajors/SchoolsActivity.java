package ir.medu.khn.highschoolmajors;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SchoolsActivity extends AppCompatActivity {

    RecyclerView mSchools_RecyclerView;
    LinearLayoutManager mSchoolsRcVw_LayoutManager;
    SchoolsRcVwAdapter mSchoolsRcVw_Adapter;
    ArrayList<SchoolsRcVwItem> schoolsRcVwItems_List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);
        //Define view objects
        defineObjects();
        //Draw Menu
        makeList();
        buildRecyclerView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater schoolsMenuInflator = getMenuInflater();
        schoolsMenuInflator.inflate(R.menu.majors_menu,menu);

        MenuItem search_MnuItem = menu.findItem(R.id.search_MajorsMnuItm);
        SearchView searchView = (SearchView) search_MnuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
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
        return true;
    }

    private void defineObjects() {
        mSchools_RecyclerView = findViewById(R.id.schoolsItems_RcVw);

    }

    private void buildRecyclerView()
    {        
        mSchools_RecyclerView.setHasFixedSize(true);
        mSchoolsRcVw_LayoutManager = new LinearLayoutManager(this);
        mSchoolsRcVw_Adapter = new SchoolsRcVwAdapter(schoolsRcVwItems_List);
        mSchools_RecyclerView.setLayoutManager(mSchoolsRcVw_LayoutManager);
        mSchools_RecyclerView.setAdapter(mSchoolsRcVw_Adapter);
    }
    private void makeList()
    {
        schoolsRcVwItems_List = new ArrayList<>();
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 2","Line 2 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 2","Line 2 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Item 1","Line 1 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Item 2","Line 2 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Item 3","Line 3 Sub"));

        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Item 2","Line 2 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Item 2","Line 2 Sub"));
        schoolsRcVwItems_List.add(new SchoolsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

    }

}
