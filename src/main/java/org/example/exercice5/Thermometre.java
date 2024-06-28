package org.example.exercice5;

public class Thermometre {
    private double kelvin;

    public Thermometre(double kelvin) {
        this.kelvin = kelvin;
    }

    public Thermometre(double temperature, UniteTemperature unite) {
//        switch (unite){
//            case KELVIN :
//                this.kelvin = temperature;
//                break;
//            case CELSIUS:
//                setCelsius(temperature);
//                break;
//            case FAHRENHEIT:
//                setFahrenheit(temperature);
//                break;
//        }

        switch (unite){
            case KELVIN -> this.kelvin = temperature; //setKelvin(temperature);
            case CELSIUS -> setCelsius(temperature);
            case FAHRENHEIT -> setFahrenheit(temperature);
        }

    }

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }


    public double getCelsius() {
        return kelvin + 273.15;
    }

    public void setCelsius(double celsius) {
        this.kelvin = celsius - 273.15;
    }

    public double getFahrenheit() {
        return kelvin * 9/5 + 32 - 273.15;
    }

    public void setFahrenheit(double fahrenheit) {
        this.kelvin = (fahrenheit - 32) * 5/9 + 273.15;
    }
}