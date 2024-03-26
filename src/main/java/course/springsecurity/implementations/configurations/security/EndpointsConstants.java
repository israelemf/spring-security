package course.springsecurity.implementations.configurations.security;

public class EndpointsConstants {
    public static final String[] ENDPOINTS_POST_NOT_REQUIRING_AUTHENTICATION = {
            "/customer"
    };

    public static final String[] ENDPOINTS_NOT_REQUIRING_AUTHENTICATION = {
            "/notices",
            "/contact"
    };

    public static final String[] ENDPOINTS_WITH_REQUIRING_AUTHENTICATION = {
            "/account",
            "/balance",
            "/loans",
            "/cards"
    };

    public static String[] getEndpointsPostNotRequiringAuthentication() {
        return ENDPOINTS_POST_NOT_REQUIRING_AUTHENTICATION;
    }
    public static String[] getEndpointsNotRequiringAuthentication() {
        return ENDPOINTS_NOT_REQUIRING_AUTHENTICATION;
    }

    public static String[] getEndpointsWithRequiringAuthentication() {
        return ENDPOINTS_WITH_REQUIRING_AUTHENTICATION;
    }
}
