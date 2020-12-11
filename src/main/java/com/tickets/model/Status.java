package com.tickets.model;

public enum Status {
    ERROR(0), ACCEPT(1), IN_PROGRESS(2);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public static Status parse(int value) {
        for (Status status: Status.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
