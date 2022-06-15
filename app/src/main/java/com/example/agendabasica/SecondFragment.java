package com.example.agendabasica;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.agendabasica.Dto.EventoDto;
import com.example.agendabasica.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EventoDto eventoDto;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        eventoDto = new EventoDto();
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText txtFechaInicio = (EditText) view.findViewById(R.id.txtFechaInicio);
        txtFechaInicio.setShowSoftInputOnFocus(false);
        txtFechaInicio.setOnFocusChangeListener(this::onFocusChange);

        EditText txtFechaFin = (EditText) view.findViewById(R.id.txtFechaFinal);
        txtFechaFin.setShowSoftInputOnFocus(false);
        txtFechaFin.setOnFocusChangeListener(this::onFocusChange);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            DatePickerDialog datePicker = new DatePickerDialog(v.getContext());
            datePicker.show();
            datePicker.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    TimePickerDialog timePicker = new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            String fecha = Utils.getFecha(dayOfMonth, month, year);
                            String hora = Utils.getHora(hourOfDay, minute);
                            String fechaCompleta = fecha + " " + hora;

                            int id = view.getId();
                            int txtfe = R.id.txtFechaInicio;
                            int txtff = R.id.txtFechaFinal;
                            if (view.getId() == R.id.txtFechaInicio) {
                                eventoDto.setFechaInicio(fechaCompleta);
                                EditText txtInput = (EditText) view.findViewById(R.id.txtFechaInicio);
                                txtInput.setText(fechaCompleta);
                            }
                            if (view.getId() == R.id.txtFechaFinal){
                                eventoDto.setFechaFinal(fechaCompleta);
                                EditText txtInput = (EditText) view.findViewById(R.id.txtFechaFinal);
                                txtInput.setText(fechaCompleta);
                            }
                        }
                    }, 0, 0, false);
                    timePicker.show();
                }
            });
        }
    }
}