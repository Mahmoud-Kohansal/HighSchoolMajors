package ir.medu.khn.highschoolmajors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MajorsRcVwAdapter extends RecyclerView.Adapter<MajorsRcVwAdapter.MajorsRcVwViewHolder> {

    private ArrayList<MajorsRcVwItem> mMajorsRcVwItem_List;

    public static class MajorsRcVwViewHolder extends RecyclerView.ViewHolder{
    public ImageView mImageView;
    public TextView mHeaderTextView;
    public  TextView mSubTextView;
    public MajorsRcVwViewHolder(View itemView)
    {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView_cardView_mainRcVw);
        mHeaderTextView = itemView.findViewById(R.id.headerTextView_cardView_mainRcVw);
        mSubTextView = itemView.findViewById(R.id.subTextView_cardView_mainRcVw);

    }
    }
    public MajorsRcVwAdapter(ArrayList<MajorsRcVwItem> majorsRcVwItem_List)
    {
        mMajorsRcVwItem_List = majorsRcVwItem_List;
    }
    @Override
    public MajorsRcVwViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.majors_rcvw_item,parent,false);
        MajorsRcVwViewHolder viewHolder = new MajorsRcVwViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MajorsRcVwViewHolder holder, int position) {
        MajorsRcVwItem currentItem = mMajorsRcVwItem_List.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mHeaderTextView.setText(currentItem.getHeadeText());
        holder.mSubTextView.setText(currentItem.getSubText());
    }

    @Override
    public int getItemCount() {
        return mMajorsRcVwItem_List.size();
    }
}
