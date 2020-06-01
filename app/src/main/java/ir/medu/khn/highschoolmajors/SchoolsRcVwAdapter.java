package ir.medu.khn.highschoolmajors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SchoolsRcVwAdapter extends RecyclerView.Adapter<SchoolsRcVwAdapter.SchoolsRcVwViewHolder> implements Filterable {

    private ArrayList<SchoolInfoItem> mSchoolInfoItem_List;
    private ArrayList<SchoolInfoItem> mSchoolInfoFullItems_List;


    public static class SchoolsRcVwViewHolder extends RecyclerView.ViewHolder{
    public TextView mProvinceName_TxVw;
    public TextView mSchoolName_TxVw;
    public ImageView mGender_ImgVw;
    public TextView mFields_TxVw;
    public TextView mAddress_TxVw;


    public SchoolsRcVwViewHolder(View itemView)
    {
        super(itemView);
        mProvinceName_TxVw = itemView.findViewById(R.id.provinceName_TxVw_CardView_SchoolRcVw);
        mSchoolName_TxVw = itemView.findViewById(R.id.schoolName_TxVw_CardView_SchoolRcVw);
        mGender_ImgVw = itemView.findViewById(R.id.gender_ImgVw_CardView_SchoolRcVw);
        mFields_TxVw = itemView.findViewById(R.id.fieldsName_TxVw_CardView_SchoolRcVw);
        mAddress_TxVw = itemView.findViewById(R.id.address_TxVw_CardView_SchoolRcVw);
    }

    }

    public SchoolsRcVwAdapter(ArrayList<SchoolInfoItem> schoolsRcVwItem_List)
    {

        mSchoolInfoItem_List = schoolsRcVwItem_List;
        mSchoolInfoFullItems_List = new ArrayList<>(schoolsRcVwItem_List);

    }
    public void setFilteredList(ArrayList<SchoolInfoItem> schoolsRcVwItemFiltered_List)
    {
        mSchoolInfoItem_List = schoolsRcVwItemFiltered_List;
        notifyDataSetChanged();
    }
    @Override
    public SchoolsRcVwViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schools_rcvw_item,parent,false);
        SchoolsRcVwViewHolder viewHolder = new SchoolsRcVwViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolsRcVwViewHolder holder, int position) {
        SchoolInfoItem currentItem = mSchoolInfoItem_List.get(position);
        holder.mGender_ImgVw.setImageResource(currentItem.getGenderImgSource());
        holder.mProvinceName_TxVw.setText(currentItem.getProvinceName());
        holder.mSchoolName_TxVw.setText(currentItem.getSchoolName());
        holder.mFields_TxVw.setText(currentItem.getFields());
        holder.mAddress_TxVw.setText(currentItem.getAddress());
    }

    @Override
    public int getItemCount() {
        return mSchoolInfoItem_List.size();
    }

    @Override
    public Filter getFilter() {
        return majorsFilter;
    }

    private Filter majorsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint_CS) {
            List<SchoolInfoItem> filteredSchoolInfo_List = new ArrayList<>();
            if ( constraint_CS == null || constraint_CS.length() == 0)
            {
                filteredSchoolInfo_List.addAll(mSchoolInfoFullItems_List);
            }
            else
            {
                String filterPattern = constraint_CS.toString().toLowerCase().trim();
                for (SchoolInfoItem rcItem: mSchoolInfoFullItems_List){
                    if(rcItem.getSchoolName().toLowerCase().contains(filterPattern)
                        || rcItem.getProvinceName().toLowerCase().contains(filterPattern)
                        ||rcItem.getFields().toLowerCase().contains(filterPattern)
                        || rcItem.getAddress().toLowerCase().contains(filterPattern)
                        || rcItem.getGender().toLowerCase().contains(filterPattern)
                        )
                    {
                        filteredSchoolInfo_List.add(rcItem);
                    }
                }

            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredSchoolInfo_List;
            return  filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            mSchoolInfoItem_List.clear();
            mSchoolInfoItem_List.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };
}
