package ir.medu.khn.highschoolmajors;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Dialog;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.app.AlertDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class SchoolFilterDialog extends AppCompatDialogFragment {
    //Listener
    private SchoolFilterDialogListener listener;

    //View Objects
    private Spinner sprProvinceSchoolFilter;
    private Spinner sprFieldSchoolFilter;
    private Spinner sprGenderSchoolFilter;

    //Arrays
    //ArrayAdapter<String> provincesAdapter;
    FilterFieldAdapter provincesAdapter;
    FilterFieldAdapter fieldsAdapter;
    FilterFieldAdapter genderAdapter;
    private ArrayList<String> provinces_List;
    private ArrayList<String> fields_List;
    private ArrayList<String> gender_List;

    FileExtension fileExtension;

    //Variables
    private String provinceFilterField;
    private String fieldFilterField;
    private String genderFilterField;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_school_filter, null);
        builder.setView(view)
                .setTitle(getString(R.string.title_SchoolFilter_Dialog))
                .setNegativeButton( getString(R.string.cancel_btn), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton(getString(R.string.apply_btn), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            listener.applyFilterFields(provinceFilterField, fieldFilterField, genderFilterField);
                        }
                        catch (Exception exp)
                        {
                            Log.i("UTF-8 Error",exp.getMessage());
                        }

                    }
                });

        //Initialize
        Initialize(view);
        return builder.create();

    }

    private void Initialize(View view)
    {
        Initialize();
        defineUIWidgets(view);
        defineWidgetsEventListeners();
    }
    private void Initialize() {
        fileExtension = FileExtension.getInstance();

        //Fill province List
        provinces_List = makeProvinceListFromJsonFileExtension();
        provinces_List.add(0,getString(R.string.json_tag_province));


        //Fill field List
        fields_List = makeFieldListFromJsonFileExtension();
        fields_List.add(0,getString(R.string.json_tag_field));

        //Fill gender List
        gender_List = new ArrayList<>();
        gender_List.add(0,getString(R.string.json_tag_gender));
        String[] genders = getResources().getStringArray(R.array.gender);
        for(String gender: genders)
        {
            gender_List.add(gender);
        }
    }

    private void defineWidgetsEventListeners() {

        sprProvinceSchoolFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    provinceFilterField = "";
                }
                else
                {
                    provinceFilterField = adapterView.getItemAtPosition(i).toString();
                }

                //Toast.makeText(adapterView.getContext(), provinceFilterField,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sprFieldSchoolFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if( i == 0)
                {
                    fieldFilterField = "";
                }
                else
                {
                    fieldFilterField = adapterView.getItemAtPosition(i).toString();
                }

                //Toast.makeText(adapterView.getContext(), fieldFilterField,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sprGenderSchoolFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if( i == 0)
                {
                    genderFilterField = "";
                }
                else
                {
                    genderFilterField = adapterView.getItemAtPosition(i).toString();
                }

                //Toast.makeText(adapterView.getContext(), genderFilterField,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void defineUIWidgets(View view) {
        sprProvinceSchoolFilter = view.findViewById(R.id.province_Spr_SchoolFilter);
        sprFieldSchoolFilter = view.findViewById(R.id.field_Spr_SchoolFilter);
        sprGenderSchoolFilter = view.findViewById(R.id.gender_Spr_SchoolFilter);

        //Set province adapter options
        provincesAdapter = new FilterFieldAdapter(view.getContext(), android.R.layout.simple_spinner_item, provinces_List);
        provincesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sprProvinceSchoolFilter.setAdapter(provincesAdapter);

        //Set fields adapter options
        fieldsAdapter = new FilterFieldAdapter(view.getContext(),android.R.layout.simple_spinner_item, fields_List);
        fieldsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sprFieldSchoolFilter.setAdapter(fieldsAdapter);

        //Set gender adapter options
        //genderAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.gender, android.R.layout.simple_spinner_item);
        genderAdapter = new FilterFieldAdapter(view.getContext(),android.R.layout.simple_spinner_item, gender_List);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sprGenderSchoolFilter.setAdapter(genderAdapter);
    }

    private ArrayList<String> makeProvinceListFromJsonFileExtension()
    {
        ArrayList<String> provinceNames = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(fileExtension.readJSONFile(getContext(),"provinces.json"));
            JSONArray fieldsArray = object.getJSONArray(getString(R.string.json_tag_data));
            for (int i = 0; i < fieldsArray.length(); i++) {
                JSONObject jsonObject = fieldsArray.getJSONObject(i);
                String provinceName = jsonObject.getString(getString(R.string.json_tag_province));
                provinceNames.add(provinceName);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return provinceNames;
    }

    private ArrayList<String> makeFieldListFromJsonFileExtension()
    {
        ArrayList<String> fieldNames = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(fileExtension.readJSONFile(getContext(),"fields.json"));
            JSONArray fieldsArray = object.getJSONArray(getString(R.string.json_tag_data));
            for (int i = 0; i < fieldsArray.length(); i++) {
                JSONObject jsonObject = fieldsArray.getJSONObject(i);
                String fieldName = jsonObject.getString(getString(R.string.json_tag_field));

                //FieldInfoItem fieldInfoItem = new FieldInfoItem();
                //fieldInfoItem.setFieldName(fieldName);
                fieldNames.add(fieldName);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fieldNames;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (SchoolFilterDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement SchoolFilterDialogListener");
        }
    }
    public interface SchoolFilterDialogListener {
        void applyFilterFields(String province_FilterField, String field_FilterField, String gender_FilterField) throws UnsupportedEncodingException;
    }



}
