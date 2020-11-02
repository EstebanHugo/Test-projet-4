package com.projet4.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReunionRepository {

    private final MutableLiveData<List<ReunionSave>> _reunionsave = new MutableLiveData();
    public LiveData<List<ReunionSave>> reunionsave = _reunionsave;

    public ReunionRepository() {
        _reunionsave.postValue(Arrays.asList(
                new ReunionSave("Salle A","Mario", new Date(),30,Arrays.asList("hugo.ban@hotmail.fr","hugo.ban@hotmail.fr","hugo.ban@hotmail.fr","hugo.ban@hotmail.fr"), 1),
                new ReunionSave("Salle B","Peach", new Date(),30,Arrays.asList("hugo.ban@hotmail.fr","hugo.ban@hotmail.fr","hugo.ban@hotmail.fr","hugo.ban@hotmail.fr"), 2),
                new ReunionSave("Salle C","Luigi", new Date(),30,Arrays.asList("hugo.ban@hotmail.fr","hugo.ban@hotmail.fr","hugo.ban@hotmail.fr","hugo.ban@hotmail.fr"), 3),
                new ReunionSave("Salle D","Wario", new Date(),30,Arrays.asList("hugo.ban@hotmail.fr","hugo.ban@hotmail.fr","hugo.ban@hotmail.fr","hugo.ban@hotmail.fr"), 4)
        ));

    }
}
