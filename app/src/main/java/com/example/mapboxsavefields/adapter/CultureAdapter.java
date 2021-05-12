package com.example.mapboxsavefields.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapboxsavefields.R;
import com.example.mapboxsavefields.pojo.Crops;

import java.util.List;

public class CultureAdapter extends RecyclerView.Adapter<CultureAdapter.CultureViewHolder> {
    private List<Crops> mCultures;
    private CultureCallback cultureCallback;

    public CultureAdapter(List<Crops> cultures, CultureCallback cultureCallback){
       mCultures=cultures;
       this.cultureCallback=cultureCallback;
    }

    @NonNull
    @Override
    public CultureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_culture, parent, false);
        return new CultureAdapter.CultureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultureViewHolder holder, int position) {
       Crops culture=mCultures.get(position);

       holder.culture.setText(culture.getName());
       holder.culture.setOnClickListener(v->{
           cultureCallback.onItemClickListener(culture);
       });
    }

    @Override
    public int getItemCount() {
        return mCultures.size();
    }

    public static class CultureViewHolder extends RecyclerView.ViewHolder{
        TextView culture;
        public CultureViewHolder(@NonNull View itemView) {
            super(itemView);
            culture = itemView.findViewById(R.id.culture);
        }
    }

}
