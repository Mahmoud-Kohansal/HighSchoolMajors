package ir.medu.khn.highschoolmajors;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Dialog;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

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
                .setNegativeButton( getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton(getString(R.string.apply), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.applyFilterFields(provinceFilterField, fieldFilterField, genderFilterField);
                    }
                });
        defineObjects(view);
        defineObjectsEventListeners();
        return builder.create();

    }

    private void defineObjectsEventListeners() {

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

    private void defineObjects(View view) {
        sprProvinceSchoolFilter = view.findViewById(R.id.province_Spr_SchoolFilter);
        sprFieldSchoolFilter = view.findViewById(R.id.field_Spr_SchoolFilter);
        sprGenderSchoolFilter = view.findViewById(R.id.gender_Spr_SchoolFilter);

        //Fill province List
        provinces_List = new ArrayList<>();
        provinces_List.add("شهر مورد نظر");
        provinces_List.add("بجنورد");
        provinces_List.add("اسفراین");
        provinces_List.add("شیروان");

        //Set province adapter options
        //provincesAdapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item, provinces_List);
        provincesAdapter = new FilterFieldAdapter(view.getContext(), android.R.layout.simple_spinner_item, provinces_List);
        provincesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sprProvinceSchoolFilter.setAdapter(provincesAdapter);

        //Fill field List
        fields_List = new ArrayList<>();
        fields_List.add("رشته مورد نظر");
        fields_List.add("شبکه");
        fields_List.add("معماری");
        fields_List.add("گرافیک");

        //Set fields adapter options
        fieldsAdapter = new FilterFieldAdapter(view.getContext(),android.R.layout.simple_spinner_item, fields_List);
        fieldsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sprFieldSchoolFilter.setAdapter(fieldsAdapter);

        //Fill gender List
        gender_List = new ArrayList<>();
        gender_List.add("جنسیت");
        gender_List.add("دخترانه");
        gender_List.add("پسرانه");

        //Set gender adapter options
        genderAdapter = new FilterFieldAdapter(view.getContext(),android.R.layout.simple_spinner_item, gender_List);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sprGenderSchoolFilter.setAdapter(genderAdapter);




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
        void applyFilterFields(String province_FilterField, String field_FilterField, String gender_FilterField);
    }
}
