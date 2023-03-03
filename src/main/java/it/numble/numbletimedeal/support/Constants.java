package it.numble.numbletimedeal.support;

public final class Constants {

    private Constants() {
    }

    // JPA Auditing
    public static final String JPA_AUDITOR_PROVIDER_BEAN_NAME = "auditorProvider";
    public static final String JPA_DEFAULT_AUDITOR = "SYSTEM";

    // DB Table column definition
    public static final String DB_DELETED_DEFINITION = "bit default 0";
    public static final String DB_CREATED_AT_DEFINITION = "datetime default now()";
    public static final String DB_UPDATED_AT_DEFINITION = "datetime default now()";
}
