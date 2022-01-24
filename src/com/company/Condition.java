package com.company;

public enum Condition {
    BASE("На базе."),
    ROUTE("В пути."),
    REPAIR("На ремонте.");

    private String condition;

    Condition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
