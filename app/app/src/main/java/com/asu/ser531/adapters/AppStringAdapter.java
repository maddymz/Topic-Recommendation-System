package com.asu.ser531.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asu.ser531.ItemClickCallBack;
import com.asu.ser531.ItemClickListener;
import com.asu.ser531.R;
import com.asu.ser531.model.Topic;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AppStringAdapter extends RecyclerView.Adapter<AppStringAdapter.TopicViewHolder>{


    private Context context;
    private List<String> topicList;
    private ItemClickCallBack callback;


    public AppStringAdapter(Context context, List<String> topicList){
        this.context = context;
        this.topicList = topicList;
        this.callback = (ItemClickCallBack)context;
    }

    @NonNull
    @Override
    public AppStringAdapter.TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_topic, parent, false);
        return new AppStringAdapter.TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppStringAdapter.TopicViewHolder holder, int position) {

        final String topic = topicList.get(position);
        holder.name.setText(topic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.itemClick(topic);
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickListener.itemClicked(topic);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }


    public class TopicViewHolder extends RecyclerView.ViewHolder{

        public TextView name;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }




//    public AppStringAdapter(Context context, List<String > topicList){
//        this.context = context;
//        this.topicList = topicList;
//        clickListener = (ItemClickListener)context;
//    }
//
//
//    @NonNull
//    @Override
//    public TopicAdapter.TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//
//        View view = null;
//
//        view = LayoutInflater.from(context).inflate(R.layout.item_topic, parent, false);
//
//        return new TopicAdapter.TopicViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TopicAdapter.TopicViewHolder holder, int position) {
//
//        final Topic topic = topicList.get(position);
//        holder.name.setText(topic.getName());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickListener.itemClicked(topic);
//            }
//        });
//
////        Log.d(TAG, "onBindViewHolder: "+ topic.toString());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return topicList.size();
//    }
//
//
//    public class TopicViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView name;
//
//        public TopicViewHolder(@NonNull View itemView) {
//            super(itemView);
//            name = itemView.findViewById(R.id.name);
//        }
//    }

}
