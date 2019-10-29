package com.example.myapplication;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    //private final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_SMALL = 1;
    private static final int VIEW_TYPE_BIG = 2;
    private final int VIEW_TYPE_LOADING = 3;

    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    private static DecimalFormat df = new DecimalFormat("00.00");

    private boolean isLoading;
    private Activity activity;
    private List<MonitorClass> mItems;
    private final GridLayoutManager mLayoutManager;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    @Override
    public int getItemViewType(int position) {
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount == SPAN_COUNT_ONE) {
            return mItems.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_SMALL;
        } else {
            return mItems.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_BIG;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_BIG) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_big, parent, false);
        } else if(viewType==VIEW_TYPE_SMALL) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_small, parent, false);
        }else{
            view = LayoutInflater.from(activity).inflate(R.layout.progresbar, parent, false);
        }
        return new UserViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UserViewHolder) {
            MonitorClass monitorClass = mItems.get(position);
            UserViewHolder userViewHolder = (UserViewHolder) holder;
            userViewHolder.info.setText(mItems.get(position).getCurrDeviceClass().getCurrDeviceLocation());
            float a,b;
            String c;
            a=mItems.get(position).getLastReadingClass().getReading().getWeight();
            b=mItems.get(position).getThresoldClass().getThresoldMax();
            c=percent(a,b);
            userViewHolder.info1.setText(c);

        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void setLoaded() {
        isLoading = false;
    }



    public ContactAdapter(RecyclerView recyclerView, List<MonitorClass> items, Activity activity, GridLayoutManager layoutManager) {
        this.mItems = items;
        this.activity = activity;
        this.mLayoutManager = layoutManager;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }
    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View view) {
            super(view);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
        }
    }

    // "Normal item" ViewHolder
    private class UserViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView info;
        TextView info1;

        UserViewHolder(View itemView, int viewType) {
            super(itemView);
            if (viewType == VIEW_TYPE_BIG) {
                //image = (ImageView) itemView.findViewById(R.id.image_big);
                title = (TextView) itemView.findViewById(R.id.title_big);
                info = (TextView) itemView.findViewById(R.id.tv_info);
                info1 = (TextView) itemView.findViewById(R.id.tv_info1);
            } else {
                //image= (ImageView) itemView.findViewById(R.id.image_small);
                title = (TextView) itemView.findViewById((R.id.title_small));
                info = (TextView) itemView.findViewById(R.id.tv_info3);
                info1 = (TextView) itemView.findViewById(R.id.tv_info4);


            }

        }
    }

    private OnLoadMoreListener onLoadMoreListener;
    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    public String  percent(float weg,float max){
        Log.d("heduh", "percent: "+weg+"and"+max);
        String c=df.format(((weg/max)*100));
        Log.d("heduh", "percent: "+c);
        return c+"%";
    }
}
