package com.example.realnapster.test;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import java.util.Random;




/**
 * Created by Realnapster on 2/5/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MainHolder> {

    private List<ListItem> listItems;
    public ItemClickListener itemClickListener;
    private Random ran;


    public MyAdapter(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            Log.e("View Type",Integer.toString(viewType));
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
            return new MyViewHolder(view);
        } else  {
            Log.e("View Type",Integer.toString(viewType));
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_second, parent, false);
            return new SecondHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        final ListItem item = listItems.get(position);

        switch (holder.getItemViewType()){
            case 0:
                Log.e("Holder Type",Integer.toString(holder.getItemViewType()));
                MyViewHolder mv = (MyViewHolder)holder;
                mv.rowTextView.setText("Row Title " + item.getTitle() + "\nRow Sub Title " + item.getSubtitle());
                mv.rowImageView.setImageResource(item.getImageRes());
                mv.rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.setItemClickListener(item);
                    }
                });
                break;
            case 1:
                SecondHolder h = (SecondHolder) holder;
                Log.e("Holder Type",Integer.toString(holder.getItemViewType()));
                h.rowTextView2.setText("Row Title " + item.getTitle() + "\nRow Sub Title " + item.getSubtitle());
                h.rowImageView2.setImageResource(item.getImageRes());
                h.rowView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.setItemClickListener(item);
                    }
                });
                break;
        }


    }

    @Override
    public int getItemViewType(int position) {
        ran = new Random();
        int num = ((position + ran.nextInt(1000)) % 2);
        Log.e("Num",Integer.toString(num));
        if (num == 0) return 0;
        else return 1;
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class MainHolder extends RecyclerView.ViewHolder {

        private MainHolder(View itemView) {
            super(itemView);
        }
    }

    public class MyViewHolder extends MainHolder {

        @BindView(R.id.rowTextView)
        TextView rowTextView;
        @BindView(R.id.rowImageView)
        ImageView rowImageView;
        @BindView(R.id.rowView)
        View rowView;

        private MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public class SecondHolder extends MainHolder {

        @BindView(R.id.rowTextView2)
        TextView rowTextView2;
        @BindView(R.id.rowImageView2)
        ImageView rowImageView2;
        @BindView(R.id.rowView2)
        View rowView2;

        private SecondHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}