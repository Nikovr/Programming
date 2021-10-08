package com.nikovr;

public enum Location {
    FLOWER_CITY("Цветочный город"),
    ROAD_TO_HOME("дорога домой"),
    STREET("улица");

    private final String value;

    Location(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}
