package com.example.agendabasica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.agendabasica.Dto.EventoDto;
import com.example.agendabasica.EventListeners.ButtonEventListener;
import com.example.agendabasica.EventListeners.OnFocusEventListener;
import com.example.agendabasica.ViewModels.ActividadViewModel;
import com.example.agendabasica.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EventoDto eventoDto;
    private ActividadViewModel actividadViewModel;

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

        actividadViewModel = new ViewModelProvider(requireActivity()).get(ActividadViewModel.class);

        EditText txtFechaInicio = (EditText) view.findViewById(R.id.txtFechaInicio);
        //txtFechaInicio.setShowSoftInputOnFocus(true);
        txtFechaInicio.setOnFocusChangeListener(new OnFocusEventListener());

        EditText txtFechaFin = (EditText) view.findViewById(R.id.txtFechaFinal);
        //txtFechaFin.setShowSoftInputOnFocus(true);
        txtFechaFin.setOnFocusChangeListener(new OnFocusEventListener());

        Button btnAceptar = (Button) view.findViewById(R.id.btnConfirmar);
        btnAceptar.setOnClickListener(new ButtonEventListener(actividadViewModel));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}