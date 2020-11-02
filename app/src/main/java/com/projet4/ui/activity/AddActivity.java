package com.projet4.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.gson.internal.$Gson$Preconditions;
import com.projet4.databinding.AddreuBinding;
import com.projet4.ui.viewmodel.AddAcitvityViewModel;
import com.projet4.ui.viewmodel.AddActivityViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    private AddreuBinding binding;
    private Date datesaisie = null;
    private List<String> participants = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = AddreuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addparticipantbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailrentre = binding.participant.getText().toString();
                AddActivityViewModel.ajouterParticipant(mailrentre);
                binding.participant.setText("");
            }
        });

        binding.sethourbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker<Long> datepicker = MaterialDatePicker.Builder.datePicker().build();
                datepicker
                        .addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                            @Override
                            public void onPositiveButtonClick(Long selection) {
                                MaterialTimePicker timepicker = new MaterialTimePicker.Builder().build();
                                timepicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        int hour = timepicker.getHour();
                                        int minute = timepicker.getMinute();
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.setTimeInMillis(datepicker.getSelection());
                                        calendar.set(Calendar.HOUR_OF_DAY, hour);
                                        calendar.set(Calendar.MINUTE, minute);
                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                                        String dateString = formatter.format(calendar.getTime());
                                        AddActivityViewModel.setdate(calendar.getTime());
                                    }
                                });


                                timepicker.show(getSupportFragmentManager(), null);
                            }
                        });
                datepicker.show(getSupportFragmentManager(), null);


            }


        });
        binding.boutonvalide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        }
    }

}


