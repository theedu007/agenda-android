package com.example.agendabasica.EventListeners;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.agendabasica.Dto.EventoDto;
import com.example.agendabasica.R;
import com.example.agendabasica.Utils;

public class OnFocusEventListener implements View.OnFocusChangeListener {
    @Override
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

                            if (v.getId() == R.id.txtFechaInicio) {
                                EditText txtInput = (EditText) v.findViewById(R.id.txtFechaInicio);
                                txtInput.setText(fechaCompleta);
                            }
                            if (v.getId() == R.id.txtFechaFinal){
                                EditText txtInput = (EditText) v.findViewById(R.id.txtFechaFinal);
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
