public class Temperature {

    static double ABS_ZERO_C = -273.1;

    static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    static double toFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    static double toKelvin(double celsius) {
        return celsius - ABS_ZERO_C;
    }
}
