package ir.medu.khn.highschoolmajors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;

public class MajorsActivity extends AppCompatActivity {

    RecyclerView mMajors_RecyclerView;   
    LinearLayoutManager mMajorsRcVw_LayoutManager;
    MajorsRcVwAdapter mMajorsRcVw_Adapter;
    ArrayList<MajorsRcVwItem> majorsRcVwItems_List;
    String fieldName = "agri";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majors);
        //get caller intent Extra fields
        getIntentFromFields();
        //Define view objects
        defineObjects();
        //Draw Menu

        makeList();
        buildRecyclerView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater majorsMenuInflator = getMenuInflater();
        majorsMenuInflator.inflate(R.menu.majors_menu,menu);

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
                mMajorsRcVw_Adapter.getFilter().filter(queryText);
                return false;
            }
        });
        return true;
    }


    private void getIntentFromFields() {
        Intent intent = getIntent();
        fieldName = intent.getStringExtra(FieldsActivity.EXTRA_FIELD_NAME);
    }

    private void defineObjects() {
        mMajors_RecyclerView = findViewById(R.id.majorsItems_RcVw);

    }
    private void buildRecyclerView()
    {        
        mMajors_RecyclerView.setHasFixedSize(true);
        mMajorsRcVw_LayoutManager = new LinearLayoutManager(this);
        mMajorsRcVw_Adapter = new MajorsRcVwAdapter(majorsRcVwItems_List);
        mMajors_RecyclerView.setLayoutManager(mMajorsRcVw_LayoutManager);
        mMajors_RecyclerView.setAdapter(mMajorsRcVw_Adapter);
    }
    private void makeList()
    {
        majorsRcVwItems_List = new ArrayList<>();
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 2","Line 2 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 2","Line 2 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Item 1","Line 1 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Item 2","Line 2 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Item 3","Line 3 Sub"));

        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Item 2","Line 2 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Item 2","Line 2 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

    }

}
