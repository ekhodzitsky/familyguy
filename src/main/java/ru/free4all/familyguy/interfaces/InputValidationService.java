package ru.free4all.familyguy.interfaces;

public interface InputValidationService {
    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @return true/false.
     */
    boolean isInputValid(String p1);

    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @param p2 second param.
     * @return true/false.
     */
    boolean isInputValid(String p1, String p2);

    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @param p2 second param.
     * @param p3 third param.
     * @return true/false.
     */
    boolean isInputValid(String p1, String p2, String p3);

    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @param p2 second param.
     * @param p3 third param.
     * @param p4 fourth param.
     * @return true/false.
     */
    boolean isInputValid(String p1, String p2, String p3, String p4);

    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @param p2 second param.
     * @param p3 third param.
     * @param p4 fourth param.
     * @param p5 fifth param.
     * @return true/false.
     */
    boolean isInputValid(String p1, String p2, String p3, String p4, String p5);
}
