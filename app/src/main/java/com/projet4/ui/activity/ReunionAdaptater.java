package com.projet4.ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.projet4.R;
import com.projet4.ui.model.ReunionUi;

import java.util.ArrayList;
import java.util.List;

public class ReunionAdaptater extends RecyclerView.Adapter<ReunionAdaptater.ReunionViewModel> {

    private final List<ReunionUi> reunions = new ArrayList<>();

    public void setGithubProjects(List<ReunionUi> toDisplay) {
        this.reunions.clear(); //j'enleve tout ce qu'il y a dedans sans changer son adresse
        //puis je la remplis avec des nouvelles valeurs
        this.reunions.addAll(toDisplay);
        notifyDataSetChanged(); //je recharge la liste des vues
    }

    @NonNull
    @Override
    public ReunionViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent, false);
        return new ReunionViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReunionViewModel holder, int position) {
        holder.bind(reunions.get(position));
    }

    @Override
    public int getItemCount() {
        return reunions.size();
    }

    public class ReunionViewModel extends RecyclerView.ViewHolder {

        ImageView color;
        TextView title;
        TextView adressmail;
        ImageView removereu;




        public ReunionViewModel(@NonNull View itemView) {
            super(itemView);

            color = itemView.findViewById(R.id.color);
            title = itemView.findViewById(R.id.title);
            adressmail = itemView.findViewById(R.id.adressmail);
            removereu = itemView.findViewById(R.id.removereu);
        }

        public void bind(ReunionUi reunionUi){

            title.setText(reunionUi.getTitle());
            color.setColorFilter(reunionUi.getColor());
            adressmail.setText(reunionUi.getAdressmail());


            removereu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

            }

            });
}
}
}