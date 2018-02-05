package com.example.realnapster.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;

/**
 * Created by Realnapster on 2/5/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public List<ListItem> listItems;
    public ItemClickListener itemClickListener;

    public MyAdapter(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ListItem item = listItems.get(position);
        holder.rowTextView.setText("Row Title " + item.getTitle() + "\nRow Sub Title " + item.getSubtitle());
        holder.rowImageView.setImageResource(item.getImageRes());
        holder.rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.setItemClickListener(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rowTextView)
        TextView rowTextView;
        @BindView(R.id.rowImageView)
        ImageView rowImageView;
        @BindView(R.id.rowView)
        View rowView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
