package com.example.agendabasica.Dto;

import android.os.Parcel;
import android.os.Parcelable;

public class EventoDto implements Parcelable {

    public EventoDto() {

    }

    public EventoDto(Parcel in) {
        this.nombreEvento = in.readString();
        this.tipoDeEvento = in.readString();
        this.fechaInicio = in.readString();
        this.fechaFinal = in.readString();
    }
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getTipoDeEvento() {
        return tipoDeEvento;
    }

    public void setTipoDeEvento(String tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }

    private String fechaInicio;
    private String fechaFinal;
    private String nombreEvento;
    private String tipoDeEvento;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public EventoDto createFromParcel(Parcel in ) {
            return new EventoDto(in);
        }

        public EventoDto[] newArray(int size) {
            return new EventoDto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombreEvento);
        dest.writeString(this.tipoDeEvento);
        dest.writeString(this.fechaInicio);
        dest.writeString(this.fechaFinal);
    }
}
