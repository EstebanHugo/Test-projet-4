package com.projet4.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projet4.R;
import com.projet4.databinding.ActivityMainBinding;
import com.projet4.databinding.AddreuBinding;
import com.projet4.ui.model.ReunionUi;
import com.projet4.ui.viewmodel.ReunionViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   private ActivityMainBinding binding;

    private ReunionAdaptater adapter;
    private ReunionViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ReunionViewModel.class);


        this.adapter = new ReunionAdaptater();

        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

        viewModel.reunionui.observe(this, new Observer<List<ReunionUi>>() {
            @Override
            public void onChanged(List<ReunionUi> githubProjects) {
                adapter.setGithubProjects(githubProjects);
            }
        });

        //lorsqu'on click sur le bouton search, on récupère le texte rentré dans l'edit
        //et on lance la recherche

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

}


}