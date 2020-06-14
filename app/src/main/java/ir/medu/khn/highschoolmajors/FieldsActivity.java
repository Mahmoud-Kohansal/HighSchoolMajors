package ir.medu.khn.highschoolmajors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FieldsActivity extends AppCompatActivity {


    public static final String EXTRA_FIELD_NAME = "agriculture";
    public String AGRICULTURE_CATEGORY_NAME = "agriculture";
    public String MANUFACTURE_CATEGORY_NAME = "manufacture";
    public String SERVICES_CATEGORY_NAME = "services";
    public String ART_CATEGORY_NAME = "art";

    CardView agricultureFields_CrdVw;
    CardView manufactureFields_CrdVw;
    CardView servicesFields_CrdVw;
    CardView artFields_CrdVw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields);
        defineObjects();
        defineObjectsEventsHandlers();
    }
    private void defineObjects()
    {
        agricultureFields_CrdVw = (CardView) findViewById(R.id.agricultureFields_CrdVw_Fields);
        manufactureFields_CrdVw = (CardView) findViewById(R.id.manufacture_CrdVw_Fields);
        servicesFields_CrdVw = (CardView) findViewById(R.id.services_CrdVw_Fields);
        artFields_CrdVw = (CardView) findViewById(R.id.art_CrdVw_Fields);

    }
    private void defineObjectsEventsHandlers()
    {
        agricultureFields_CrdVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AGRICULTURE_CATEGORY_NAME = getResources().getString(R.string.agriculture_category);
                showMajorsActivity(AGRICULTURE_CATEGORY_NAME);
            }
        });
        manufactureFields_CrdVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MANUFACTURE_CATEGORY_NAME = getResources().getString(R.string.manufacture_category);
                showMajorsActivity(MANUFACTURE_CATEGORY_NAME);
            }
        });
        servicesFields_CrdVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SERVICES_CATEGORY_NAME = getResources().getString(R.string.services_category);
                showMajorsActivity(SERVICES_CATEGORY_NAME);
            }
        });
        artFields_CrdVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ART_CATEGORY_NAME = getResources().getString(R.string.art_category);
                showMajorsActivity(ART_CATEGORY_NAME);
            }
        });
    }
    public void showMajorsActivity(String majorCategory)
    {
        //Toast.makeText(getApplicationContext(),fieldName, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(FieldsActivity.this, MajorsActivity.class);
        intent.putExtra(EXTRA_FIELD_NAME,majorCategory);
        startActivity(intent);
    }
}
