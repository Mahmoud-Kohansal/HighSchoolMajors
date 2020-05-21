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

    private ArrayList<SchoolsRcVwItem> mSchoolsRcVwItem_List;
    private ArrayList<SchoolsRcVwItem> mSchoolsRcVwFullItems_List;


    public static class SchoolsRcVwViewHolder extends RecyclerView.ViewHolder{
    public ImageView mImageView;
    public TextView mHeaderTextView;
    public  TextView mSubTextView;
    public SchoolsRcVwViewHolder(View itemView)
    {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView_cardView_mainRcVw);
        mHeaderTextView = itemView.findViewById(R.id.headerTextView_cardView_mainRcVw);
        mSubTextView = itemView.findViewById(R.id.subTextView_cardView_mainRcVw);

    }
    }
    public SchoolsRcVwAdapter(ArrayList<SchoolsRcVwItem> SchoolsRcVwItem_List)
    {
        mSchoolsRcVwItem_List = SchoolsRcVwItem_List;
        mSchoolsRcVwFullItems_List = new ArrayList<>(SchoolsRcVwItem_List);

    }
    @Override
    public SchoolsRcVwViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schools_rcvw_item,parent,false);
        SchoolsRcVwViewHolder viewHolder = new SchoolsRcVwViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolsRcVwViewHolder holder, int position) {
        SchoolsRcVwItem currentItem = mSchoolsRcVwItem_List.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mHeaderTextView.setText(currentItem.getHeaderText());
        holder.mSubTextView.setText(currentItem.getSubText());
    }

    @Override
    public int getItemCount() {
        return mSchoolsRcVwItem_List.size();
    }

    @Override
    public Filter getFilter() {
        return majorsFilter;
    }

    private Filter majorsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint_CS) {
            List<SchoolsRcVwItem> filteredMajors_List = new ArrayList<>();
            if ( constraint_CS == null || constraint_CS.length() == 0)
            {
                filteredMajors_List.addAll(mSchoolsRcVwFullItems_List);
            }
            else
            {
                String filterPattern = constraint_CS.toString().toLowerCase().trim();
                for (SchoolsRcVwItem rcItem: mSchoolsRcVwFullItems_List){
                    if(rcItem.getHeaderText().toLowerCase().contains(filterPattern))
                    {
                        filteredMajors_List.add(rcItem);
                    }
                }

            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredMajors_List;
            return  filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            mSchoolsRcVwItem_List.clear();
            mSchoolsRcVwItem_List.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };
}
