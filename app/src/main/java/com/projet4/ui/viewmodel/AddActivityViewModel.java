package com.projet4.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.projet4.data.ReunionSave;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddActivityViewModel extends ViewModel {

    private Date date = null;
    private List<String> participants = new ArrayList();

    private final MutableLiveData<ViewState> _viewState = new MutableLiveData<ViewState>();
    private final LiveData<ViewState> viewState = _viewState;

    public AddActivityViewModel() {
        //constructeur vide
    }

    public void onDateSaisie(Date nouvelleDate) {
        this.date = nouvelleDate;
        updateViewState();
    }
    public void ajouterParticipant(String participan) {
        this.participants.add(participant);
        updateViewState();
    }

    private static void updateViewState() {
        String dateString = null;
        if(date != null){
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            dateString = formatter.format(date);
        }
        //faire aussi pour participants
        String participants = "";
        for(int i = 0, ...)
        //ta boucle for que tu as déjà, qui créé le string

        ViewState newState = new ViewState(dateString, participants);
        _viewState.postValue(newState);
    }

    //contiens que des strings, qui seront utilisés dans des .setText
    public static class ViewState {
        private String date;
        private String participants;

        public ViewState(String date, String participants) {
            this.date = date;
            this.participants = participants;
        }

        //getters

        public String getDate() {
            return date;
        }

        public String getParticipants() {
            return participants;
        }
    }
}
