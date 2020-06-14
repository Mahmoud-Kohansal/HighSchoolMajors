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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MajorsActivity extends AppCompatActivity {

    RecyclerView mMajors_RecyclerView;   
    LinearLayoutManager mMajorsRcVw_LayoutManager;
    MajorsRcVwAdapter mMajorsRcVw_Adapter;
    ArrayList<MajorInfoItem> mMajorsInfoItems_FullList;
    String majorCategory = "agriculture";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majors);
        //get caller intent Extra fields
        majorCategory = getIntentFromFields();
        Toast.makeText(this,majorCategory,Toast.LENGTH_LONG).show();

        //Define view objects
        defineObjects();
        //Draw Menu

        //mMajorsInfoItems_FilteredList = FilterListByCategory(mMajorsInfoItems_FullList, fieldCategory);
        //makeList();
        mMajorsInfoItems_FullList = makeSchoolsListFromJsonFileExtension();
        buildRecyclerView(mMajorsInfoItems_FullList);
        //Filter by Category
        mMajorsRcVw_Adapter.getFilter().filter(majorCategory);

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


    private String getIntentFromFields() {
        Intent intent = getIntent();
        return intent.getStringExtra(FieldsActivity.EXTRA_FIELD_NAME);
    }

    private void defineObjects() {
        mMajors_RecyclerView = findViewById(R.id.majorsItems_RcVw);

    }
    private void buildRecyclerView(ArrayList<MajorInfoItem> majorsInfoItems_List)
    {        
        mMajors_RecyclerView.setHasFixedSize(true);
        mMajorsRcVw_LayoutManager = new LinearLayoutManager(this);
        mMajorsRcVw_Adapter = new MajorsRcVwAdapter(majorsInfoItems_List);
        mMajors_RecyclerView.setLayoutManager(mMajorsRcVw_LayoutManager);
        mMajors_RecyclerView.setAdapter(mMajorsRcVw_Adapter);
    }
    private ArrayList<MajorInfoItem> makeSchoolsListFromJsonFileExtension()
    {
        ArrayList<MajorInfoItem> majorInfoItems = new ArrayList<>();
        FileExtension fileExtension = FileExtension.getInstance();
        try {
            JSONObject object = new JSONObject(fileExtension.readJSONFile(this,"fields.json"));
            JSONArray fieldsArray = object.getJSONArray(getString(R.string.json_tag_data));
            for (int i = 0; i < fieldsArray.length(); i++) {

                JSONObject jsonObject = fieldsArray.getJSONObject(i);
                String majorName = jsonObject.getString(getString(R.string.json_tag_name));
                String majorCategory = jsonObject.getString(getString(R.string.json_tag_category));
                String majorIntroduction = jsonObject.getString(getString(R.string.json_tag_introduction));

                MajorInfoItem majorInfoItem = new MajorInfoItem();
                majorInfoItem.setMajorName(majorName);
                majorInfoItem.setMajorCategory(majorCategory);
                majorInfoItem.setMajorDescription(majorIntroduction);

                majorInfoItems.add(majorInfoItem);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return majorInfoItems;
    }

}
