package com.aayaz.news.database.tables;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aayaz.news.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 *  Fact data adapter to data in recycler view
 */

public class FactAdapter extends RecyclerView.Adapter<FactAdapter.MyViewHolder> {

    private Context context;
    private List<Fact> facts;

    public FactAdapter(Context context, List<Fact> facts) {
        this.context = context;
        this.facts = facts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fact_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Fact fact = facts.get(position);

        holder.textViewTitle.setText(fact.getTitle());
        holder.textViewDescription.setText(fact.getDescription());

        Glide.with(context)
                .load(fact.getImageHref())
                .centerCrop()
                .into(holder.imageViewFactImage);

    }

    @Override
    public int getItemCount() {
        return facts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitle;
        public TextView textViewDescription;
        public ImageView imageViewFactImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textView_news_title);
            textViewDescription = itemView.findViewById(R.id.textView_news_description);
            imageViewFactImage = itemView.findViewById(R.id.imageview_fact_image);

        }
    }
}
