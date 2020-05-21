package ir.medu.khn.highschoolmajors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FieldsActivity extends AppCompatActivity {

    public static final String EXTRA_FIELD_NAME = "agri";
    public static final String AGRI_FIELD_NAME = "agri";
    public static final String SANAT_FIELD_NAME = "sanat";
    public static final String SERVICES_FIELD_NAME = "services";
    public static final String ART_FIELD_NAME = "art";

    CardView agriFields_CrdVw;
    CardView sanatFields_CrdVw;
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
        agriFields_CrdVw = (CardView) findViewById(R.id.agriFields_CrdVw);
        sanatFields_CrdVw = (CardView) findViewById(R.id.sanatFields_CrdVw);
        servicesFields_CrdVw = (CardView) findViewById(R.id.servicesFields_CrdVw);
        artFields_CrdVw = (CardView) findViewById(R.id.artFields_CrdVw);

    }
    private void defineObjectsEventsHandlers()
    {
        agriFields_CrdVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMajorsActivity(AGRI_FIELD_NAME);
            }
        });
        sanatFields_CrdVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMajorsActivity(SANAT_FIELD_NAME);
            }
        });
        servicesFields_CrdVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMajorsActivity(SERVICES_FIELD_NAME);
            }
        });
        artFields_CrdVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMajorsActivity(ART_FIELD_NAME);
            }
        });
    }
    public void showMajorsActivity(String fieldName)
    {
        //Toast.makeText(getApplicationContext(),fieldName, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(FieldsActivity.this, MajorsActivity.class);
        intent.putExtra(EXTRA_FIELD_NAME,fieldName);
        startActivity(intent);
    }
}
