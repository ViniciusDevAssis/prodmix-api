package com.prodmix.api.enums;

public enum Status {

    ACTIVE("ATIVO"),
    INACTIVE("INATIVO");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status não encontrado para o valor: " + value);
    }
}
