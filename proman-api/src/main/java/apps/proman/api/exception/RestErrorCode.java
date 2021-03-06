package apps.proman.api.exception;

import java.util.HashMap;
import java.util.Map;

import apps.proman.service.common.exception.ErrorCode;

public enum RestErrorCode implements ErrorCode  {

    ATH_001("ATH-001", "Authorization header is missing."),

    ATH_002("ATH-002", "Only basic or bearer authentication is supported.");

    private static final Map<String, RestErrorCode> LOOKUP = new HashMap<>();

    static {
        for (final RestErrorCode enumeration : RestErrorCode.values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private final String code;

    private final String defaultMessage;

    private RestErrorCode(final String code, final String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDefaultMessage() {
        return defaultMessage;
    }

}