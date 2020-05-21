package ir.medu.khn.highschoolmajors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapaterRcVw;
    private RecyclerView.LayoutManager mLayoutManagerRcVw;
    private CardView introduceFieldsCrdVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defineObjects();
        setObjectsListeners();

    }

    private void defineObjects()
    {
        introduceFieldsCrdVw = findViewById(R.id.introduceFields_CrdVw);
    }
    private void setObjectsListeners()
    {
        introduceFieldsCrdVw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent introduceFieldsActivity = new Intent(MainActivity.this,FieldsActivity.class);
                startActivity(introduceFieldsActivity);
            }
        });
    }
    private void SayHi()
    {
        Toast.makeText(getApplicationContext(),"Hi there",Toast.LENGTH_LONG).show();
    }

}
