package course.springsecurity.implementations.configurations.security;

public class EndpointsConstants {
    public static final String[] ENDPOINTS_GET_REQUIRING_AUTHENTICATION = {
            "/customer"
    };
    public static final String[] ENDPOINTS_GET_NOT_REQUIRING_AUTHENTICATION = {
            "/notices"
    };
    public static final String[] ENDPOINTS_REQUEST_NOT_REQUIRING_AUTHENTICATION = {
            "/customer",
            "/contact"
    };
    public static final String[] ENDPOINTS_WITH_REQUIRING_AUTHENTICATION = {
            "/account",
            "/balance",
            "/loans",
            "/cards"
    };

    public static String[] getEndpointsGetRequiringAuthentication() {
        return ENDPOINTS_GET_REQUIRING_AUTHENTICATION;
    }
    public static String[] getEndpointsRequestNotRequiringAuthentication() {
        return ENDPOINTS_REQUEST_NOT_REQUIRING_AUTHENTICATION;
    }
    public static String[] getEndpointsGetNotRequiringAuthentication() {
        return ENDPOINTS_GET_NOT_REQUIRING_AUTHENTICATION;
    }

    public static String[] getEndpointsWithRequiringAuthentication() {
        return ENDPOINTS_WITH_REQUIRING_AUTHENTICATION;
    }
}
