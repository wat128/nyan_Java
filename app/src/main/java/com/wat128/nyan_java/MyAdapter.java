package com.wat128.nyan_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter{

    private List iImages;
    private List iNames;
    private List iEmails;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView emailView;

        ViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.image_view);
            textView = v.findViewById(R.id.text_view);
            emailView = v.findViewById(R.id.email_view);
        }
    }

    MyAdapter(List itemImages, List itemNames, List itemEmails) {
        this.iImages = itemImages;
        this.iNames = itemNames;
        this.iEmails = itemEmails;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(iImages.get(position));
        holder.textView.setText(iNames.get(position));
        holder.emailView.setTextSize(iEmails.get(position));
    }

    @Override
    public int getItemCount() {
        return iNames.size();
    }
}
