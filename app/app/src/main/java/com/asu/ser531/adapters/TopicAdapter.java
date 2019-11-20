package com.asu.ser531.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asu.ser531.ItemClickListener;
import com.asu.ser531.R;
import com.asu.ser531.model.Topic;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder>{


    private static final String TAG = "TopicAdapter";
    private Context context;
    private List<Topic> topicList;
    private ItemClickListener clickListener;
    private boolean isPrereq;

    public TopicAdapter(Context context, List<Topic> topicList){
        this.context = context;
        this.topicList = topicList;
        clickListener = (ItemClickListener)context;
    }

    public TopicAdapter(Context context, List<Topic> topicList, boolean isPrereq){
        this(context, topicList);
        this.isPrereq = isPrereq;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = null;

        if(isPrereq){
            view = LayoutInflater.from(context).inflate(R.layout.item_prereq, parent, false);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.item_topic, parent, false);
        }

        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {

        final Topic topic = topicList.get(position);
        holder.name.setText(topic.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.itemClicked(topic);
            }
        });

        Log.d(TAG, "onBindViewHolder: "+ topic.toString());

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

}
