package com.delaroystudios.recyclerviewfragment;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by delaroy on 2/13/17.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] mDataset;
    private String[] noOfRooms;
    private String[] price;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView roomId;
        public TextView noOfRoom;
        public TextView roomPrice;
        public MyViewHolder(View v){
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            roomId = (TextView) v.findViewById(R.id.tv_text);
            noOfRoom = (TextView) v.findViewById(R.id.tv_text1);
            roomPrice = (TextView)v.findViewById((R.id.tv_text2));

        }

    }



    public MyAdapter(String[] myDataset, String[] noOfRooms,String[] price){
        this.noOfRooms = noOfRooms;
        this.price = price;
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.roomId.setText(mDataset[position]);
        holder.noOfRoom.setText(noOfRooms[position]);
        holder.roomPrice.setText(price[position]);

    }

    @Override
    public int getItemCount() { return mDataset.length; }

}
