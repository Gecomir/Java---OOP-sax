package WorkingWithAbstraction.HotelReservation;

import java.util.Locale;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int multiply;

    Season(int multiply) {
        this.multiply = multiply;
    }

    public int getMultiply() {
        return multiply;
    }

    public static Season parse(String s) {
        return Season.valueOf(s.toUpperCase());
    }
}
