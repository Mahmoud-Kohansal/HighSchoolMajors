package ir.medu.khn.highschoolmajors;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FilterFieldAdapter extends ArrayAdapter<String> {


    public FilterFieldAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    //@NonNull
    //@Override
    //public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {
      //  return super.getView(position, convertView, parent);
        //initView --> convertView = LayoutInflater.from(getContext()).inflate(
        //                    R.layout.country_spinner_row, parent, false
        //https://codinginflow.com/tutorials/android/custom-spinner
    //}


    @Override
    public boolean isEnabled(int position) {
        //return super.isEnabled(position);
        return (position == 0 ? false : true);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View view = super.getView(position, convertView, parent);
        TextView txVw = (TextView) view;
        if(position == 0)
        {
            txVw.setTextColor(Color.GRAY);
        }
        return txVw;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getDropDownView(position, convertView, parent);
        View view = super.getDropDownView(position, convertView, parent);
        TextView txVw = (TextView) view;
        if(position == 0)
        {
            txVw.setTextColor(Color.GRAY);
        }
        return txVw;
    }
}
