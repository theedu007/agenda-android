package com.example.agendabasica.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.agendabasica.Dto.EventoDto;

import java.util.ArrayList;
import java.util.List;

public class ActividadViewModel extends ViewModel {
    private MutableLiveData<List<EventoDto>> eventos;

    public ActividadViewModel() {
        eventos = new MutableLiveData<List<EventoDto>>();
        eventos.setValue(new ArrayList<EventoDto>());
    }

    public void AgregarActividad(EventoDto nuevoEvento) {
        eventos.getValue().add(nuevoEvento);
    }

    public LiveData<List<EventoDto>> ObtenerEventos() {
        return eventos;
    }
}
