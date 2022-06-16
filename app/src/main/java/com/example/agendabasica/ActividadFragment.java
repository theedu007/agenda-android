package com.example.agendabasica;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.agendabasica.Dto.EventoDto;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActividadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActividadFragment extends Fragment {

    private static final String ARG_EVENTO = "1";

    private EventoDto mEvento;

    public ActividadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ActividadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActividadFragment newInstance(EventoDto eventoDto) {
        ActividadFragment fragment = new ActividadFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_EVENTO, eventoDto);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mEvento = getArguments().getParcelable(ARG_EVENTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actividad, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView txtTipoActividad = (TextView) view.findViewById(R.id.idLabelTipoActividad);
        TextView txtNombreActividad = (TextView) view.findViewById(R.id.idLabelActividad);
        TextView txtFechaInicio = (TextView) view.findViewById(R.id.idLabelFechaInicio);
        TextView txtFechaFinal = (TextView) view.findViewById(R.id.idLabelFechaFinal);

        txtTipoActividad.setText(mEvento.getTipoDeEvento());
        txtNombreActividad.setText(mEvento.getNombreEvento());
        txtFechaInicio.setText(mEvento.getFechaInicio());
        txtFechaFinal.setText(mEvento.getFechaFinal());
    }
}