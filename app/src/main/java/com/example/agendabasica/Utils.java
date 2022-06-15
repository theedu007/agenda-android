package com.example.agendabasica;

public class Utils {
    public static String getFecha(int dayOfMonth, int month, int year) {
        StringBuilder fechaBuilder = new StringBuilder();
        fechaBuilder.append(dayOfMonth);
        fechaBuilder.append("/");
        fechaBuilder.append(month);
        fechaBuilder.append("/");
        fechaBuilder.append(year);

        return fechaBuilder.toString();
    }

    public static String getHora(int hourOfDay, int minute) {
        StringBuilder horaBuilder = new StringBuilder();
        horaBuilder.append(hourOfDay);
        horaBuilder.append(":");
        horaBuilder.append(minute);
        horaBuilder.append(" ");
        String aux = hourOfDay >= 12 ? "PM" : "AM";
        horaBuilder.append(aux);

        return horaBuilder.toString();
    }
}
