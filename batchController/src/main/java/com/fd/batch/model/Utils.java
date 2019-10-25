package com.fd.batch.model;

import org.apache.logging.log4j.Logger;


/**
 * @author Froy
 */
public class Utils {

    private Utils() {
    }

    /**
     * Static LOGGER (log4j2)
     */
    public static Logger LOGGER;

    //Labels -----------------------------
    public static String UNEXPECTED_ERROR = "UNEXPECTED ERROR";
    public static String NOT_STARTED = "NOT STARTED";

    public static final String APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE = "Content-Type";

    /**
     * Gets the value passed by parameter adding blank spaces to complete the size of the column
     * if the value exceeds the size this will make a substring of the surplus.
     *
     * @param value
     * @param size
     * @return
     */
    public static String addValueColumnSize(Object value, int size) {
        String valueAux = "";
        if (value != null) {
            valueAux = value.toString().trim();
        }
        return String.format("%-" + size + "." + size + "s", valueAux);
    }

}
