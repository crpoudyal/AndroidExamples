package com.androidexamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerListDataAdapter extends RecyclerView.Adapter<RecyclerListDataAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<ListData> listItems;
    private LayoutInflater mInflater;

    public RecyclerListDataAdapter(Context context, ArrayList<ListData> ListItems){
        this.mContext = context;
        this.listItems = ListItems;
        this.mInflater = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListData data = listItems.get(position);

        holder.tvName.setText(data.getName());
        holder.tvAddress.setText(data.getAddress());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_addr);

        }
    }
}
