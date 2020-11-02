package com.projet4.ui.viewmodel;

import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.projet4.data.ReunionRepository;
import com.projet4.data.ReunionSave;
import com.projet4.ui.model.ReunionUi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReunionViewModel extends ViewModel {

    private ReunionRepository reunionrepository = new ReunionRepository();




    private final MediatorLiveData<List<ReunionUi>> _reunionui = new MediatorLiveData();
    public LiveData<List<ReunionUi>> reunionui = _reunionui;

    public ReunionViewModel() {
        _reunionui.addSource(reunionrepository.reunionsave, new Observer<List<ReunionSave>>() {
            @Override
            public void onChanged(List<ReunionSave> reunionSaves) { //reunionui écoute tout ce qui se passe dans reunionSave

        List<ReunionUi> reunionaffiche = new ArrayList<>();
                for (int i = 0; i < reunionSaves.size(); i++) {
                    ReunionSave reunionsave = reunionSaves.get(i);
                    String emails = "";
                    for (int i1 = 0; i1 < reunionsave.getAdressmails().size(); i1++) {
                        String s = reunionsave.getAdressmails().get(i1);
                        emails = emails + s + ",";
                    }
                    ReunionUi reunionui = new ReunionUi(Color.BLACK, reunionsave.getLieu() + " - " + reunionsave.getSujetdereu(), emails, reunionsave.getIdentifiant());
                    reunionaffiche.add(reunionui);
                }
                _reunionui.postValue(reunionaffiche);
            }
        });

    }


}
