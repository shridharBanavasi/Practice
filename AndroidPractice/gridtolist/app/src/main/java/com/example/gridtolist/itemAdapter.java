package com.example.gridtolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ItemViewHolder>{
    public static final int SPAN_COUNT_ONE=1;
    public static final int SPAN_COUNT_THREE=3;

    private static final int VIEW_TYPE_SMALL=1;
    private static final int VIEW_TYPE_BIG=2;

    private List<item> mItems;
    private GridLayoutManager mLayoutManager;

    public itemAdapter(List<item> items, GridLayoutManager layoutManager) {
        mItems = items;
        mLayoutManager = layoutManager;

    }

    public int getItemViewType(int position) {
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount == SPAN_COUNT_ONE) {
            return VIEW_TYPE_BIG;
        } else {
            return VIEW_TYPE_SMALL;
        }
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_BIG) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_big, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_small, parent, false);
        }
        return new ItemViewHolder(view, viewType);
    }


    public void onBindViewHolder(ItemViewHolder holder,int position) {
        item item = mItems.get(position % 15);
        holder.title.setText(item.getTitle());
        holder.iv.setImageResource(item.getImgResId());
        holder.info.setText(item.getDesc());
        holder.info1.setText(item.getComments());

    }

    public int getItemCount(){
        return 15;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView title;
        TextView info;
        TextView info1;

        ItemViewHolder(View itemView,int viewType){
            super(itemView);
            if (viewType==VIEW_TYPE_BIG) {
                iv = (ImageView) itemView.findViewById(R.id.image_big);
                title = (TextView) itemView.findViewById(R.id.title_big);
                info = (TextView) itemView.findViewById(R.id.tv_info);
                info1 = (TextView) itemView.findViewById(R.id.tv_info1);
            }else{
                iv=(ImageView)itemView.findViewById(R.id.image_small);
                title=(TextView)itemView.findViewById((R.id.title_small));
                info = (TextView) itemView.findViewById(R.id.tv_info3);
                info1 = (TextView) itemView.findViewById(R.id.tv_info4);


    }


        }
    }
}
