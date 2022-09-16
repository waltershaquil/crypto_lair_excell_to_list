package com.example.extoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.ViewHolder> {


    private List<Coin> mCoins;

    // Pass in the contact array into the constructor
    public CoinsAdapter(List<Coin> coins) {
        mCoins = coins;
    }

    @NonNull
    @Override
    public CoinsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View coinView = inflater.inflate(R.layout.custom_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(coinView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinsAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Coin coin = mCoins.get(position);

        // Set item views based on your views and data model
        TextView name = holder.name;
        name.setText(coin.getName());
        TextView units = holder.units;
        units.setText((int)coin.getAmount());
        TextView value = holder.value;
        value.setText((int)coin.getValue());

    }

    @Override
    public int getItemCount() {
        return mCoins.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView units;
        public TextView value;

        public ViewHolder(View itemView){

            super(itemView);
            name = itemView.findViewById(R.id.coin);
            units = itemView.findViewById(R.id.units);
            value = itemView.findViewById(R.id.value);


        }


    }
}
