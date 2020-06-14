package ir.medu.khn.highschoolmajors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MajorsRcVwAdapter extends RecyclerView.Adapter<MajorsRcVwAdapter.MajorsRcVwViewHolder> implements Filterable {

    private ArrayList<MajorInfoItem> mMajorInfoItem_List;
    private ArrayList<MajorInfoItem> mMajorsRcVwFullItems_List;


    public static class MajorsRcVwViewHolder extends RecyclerView.ViewHolder{
    public  TextView mMajorName_TxtVw;
    public MajorsRcVwViewHolder(View itemView)
    {
        super(itemView);
        mMajorName_TxtVw = itemView.findViewById(R.id.majorName_cardView_majorRcVw);

    }
    }
    public MajorsRcVwAdapter(ArrayList<MajorInfoItem> MajorInfoItem_List)
    {
        mMajorInfoItem_List = MajorInfoItem_List;
        mMajorsRcVwFullItems_List = new ArrayList<>(MajorInfoItem_List);

    }
    @Override
    public MajorsRcVwViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.majors_rcvw_item,parent,false);
        MajorsRcVwViewHolder viewHolder = new MajorsRcVwViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MajorsRcVwViewHolder holder, int position) {
        MajorInfoItem currentItem = mMajorInfoItem_List.get(position);
        holder.mMajorName_TxtVw.setText(currentItem.getMajorName());
    }

    @Override
    public int getItemCount() {
        return mMajorInfoItem_List.size();
    }

    @Override
    public Filter getFilter() {
        return majorsFilter;
    }

    private Filter majorsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint_CS) {
            List<MajorInfoItem> filteredMajors_List = new ArrayList<>();
            if ( constraint_CS == null || constraint_CS.length() == 0)
            {
                filteredMajors_List.addAll(mMajorsRcVwFullItems_List);
            }
            else
            {
                String filterPattern = constraint_CS.toString();
                for (MajorInfoItem rcItem: mMajorsRcVwFullItems_List){
                    if(rcItem.getMajorCategory().equals(filterPattern))
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

            mMajorInfoItem_List.clear();
            mMajorInfoItem_List.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };
}
