package com.prodmix.api.enums;

public enum Category {

    CEREALS("CEREAIS"),
    DAIRY("LATICINIOS"),
    COLD_CUTS("FRIOS"),
    FROZEN("CONGELADOS"),
    CLEANING("LIMPEZA"),
    PERFUMERY("PERFUMARIA"),
    HYGIENE("HIGIENE"),
    UTILITIES("UTILIDADES"),
    BEVERAGES("BEBIDAS"),
    CANNED_GOODS("ENLATADOS E CONSERVAS"),
    SWEETS_AND_COOKIES("DOCES E BISCOITOS"),
    GROCERY("MERCEARIA"),
    BAKERY("PADARIA E CONFEITARIA"),
    MEAT("CARNES"),
    PRODUCE("HORTIFRUTI"),
    PET_CARE("PETSHOP"),
    HEALTHY("NATURAIS / DIET / LIGHT"),
    DISPOSABLES("DESCARTAVEIS E EMBALAGENS"),
    TOOLS("MANUTENÇÃO e FERRAMENTAS");

    private final String value;

    Category(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static Category fromCategory(String value){
        for (Category category : Category.values()) {
            if (category.getValue().equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Category não encontrado para o valor: " + value);
    }
}
