package ru.free4all.familyguy.service;

import org.springframework.stereotype.Service;
import ru.free4all.familyguy.interfaces.InputValidationService;

@Service
public class InputValidationServiceImpl implements InputValidationService {
    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @return true/false.
     */
    @Override
    public boolean isInputValid(String p1) {
        return p1 != null && !p1.equals("");
    }

    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @param p2 second param.
     * @return true/false.
     */
    @Override
    public boolean isInputValid(String p1, String p2) {
        return isInputValid(p1) && isInputValid(p2);
    }

    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @param p2 second param.
     * @param p3 third param.
     * @return true/false.
     */
    @Override
    public boolean isInputValid(String p1, String p2, String p3) {
        return isInputValid(p1, p2) && isInputValid(p3);
    }

    /**
     * Checks if input is not empty.
     *
     * @param p1 first param.
     * @param p2 second param.
     * @param p3 third param.
     * @param p4 fourth param.
     * @return true/false.
     */
    @Override
    public boolean isInputValid(String p1, String p2, String p3, String p4) {
        return isInputValid(p1, p2, p3) && isInputValid(p4);
    }

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
    @Override
    public boolean isInputValid(String p1, String p2, String p3, String p4, String p5) {
        return isInputValid(p1, p2, p3, p4) && isInputValid(p5);
    }
}
