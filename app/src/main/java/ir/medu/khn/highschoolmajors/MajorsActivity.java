package ir.medu.khn.highschoolmajors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

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
        makeList();
        buildRecyclerView();

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

        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 2","Line 2 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 2","Line 2 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 1","Line 1 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 2","Line 2 Sub"));
        majorsRcVwItems_List.add(new MajorsRcVwItem(R.drawable.icon2,"Line 3","Line 3 Sub"));

    }

}
