package com.example.agendabasica.EventListeners;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;

import com.example.agendabasica.Dto.EventoDto;
import com.example.agendabasica.R;
import com.example.agendabasica.ViewModels.ActividadViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class ButtonEventListener implements View.OnClickListener{

    private ActividadViewModel _viewModel;

    public ButtonEventListener(ActividadViewModel viewModel) {
        _viewModel = viewModel;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConfirmar) {

            Activity rootView = ((Activity) v.getContext());
            Spinner spinner = (Spinner) rootView.findViewById(R.id.dropdownTipoEvento);
            TextInputLayout txtNombre = (TextInputLayout) rootView.findViewById(R.id.txtNombreEvento);
            EditText txtFechaInicio = (EditText) rootView.findViewById(R.id.txtFechaInicio);
            EditText txtFechaFinal = (EditText) rootView.findViewById(R.id.txtFechaFinal);

            EventoDto eventoDto = new EventoDto();
            eventoDto.setTipoDeEvento(spinner.getSelectedItem().toString());
            eventoDto.setNombreEvento(txtNombre.getEditText().getText().toString());
            eventoDto.setFechaInicio(txtFechaInicio.getText().toString());
            eventoDto.setFechaFinal(txtFechaFinal.getText().toString());

            _viewModel.AgregarActividad(eventoDto);

            Navigation.findNavController(v)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment);
        }
    }
}
