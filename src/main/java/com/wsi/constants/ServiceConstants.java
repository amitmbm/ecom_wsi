package com.wsi.constants;

public class ServiceConstants {
	public static final String USER_NAME = "username";
	public static final String USER_ID = "userid";
	public static final String PASSWORD = "password";
	public static final String ANONYMOUS_USER_ID = "anonymous";
	public static final Long ANONYMOUS_USER_PUID = 3L;
    public static final String ANONYMOUS_USER_FIRSTNAME = "Anonymous";
    public static final String ANONYMOUS_USER_LASTNAME = "User";

	public static final String AUTH_SERVICE_PROP_FILE = "authService";

	/*
	 * System Properties
	 */
	
    public static final String USE_DEFAULT_ALGO_DSA = "USE_DSA_AS_DEFAULT_FOR_TOKEN_SIGNING";

    public static final String ADMIN_USERSTORE_PROVIDER = "ADMIN_USERSTORE_PROVIDER";
    public static final String AUTH = "AUTH";

    /*
     * Request-Response variables
     */
    public static final String ContentType = "Content-Type";
	public static final String AUTHORIZATION = "Authorization";
	public static final int MAX_X_HEADER_LIMIT = 7;

    public static final String USERSTORE = "userstore";
    public static final String USERSTORE_ALIAS1 = "User Store";
   	public static final int SSL_PORT = 443;
	public static final String KONY_GLOBAL = "kony";
	public static final String URN_SEPARATOR = ":";
	public static final String PROFILE = "profile";
	public static final String PATTERN_APPID = "^[a-zA-Z0-9_-]+$";
	public static final char CSV_DELIMITER = ',';
	
	//session constants
	public static final String SESSION_TYPE_KEY = "session_type";
	public static final String SESSION_TYPE_OAUTH = "oauth";
	public static Long SESSION_CLIAMS_TTL = 5L*60L*1000L; // 5 minutes in milliseconds

	public static final String PROVIDER_NAME_REGEX = "^[A-Za-z0-9]{2,65}$";

	
	// User Status related Constants
	public static final String USER_STATUS_ACTIVE = "active";
	public static final String USER_STATUS_PENDING = "pending";
	public static final String USER_STATUS_BLOCKED = "blocked";
	public static final String USER_STATUS_DISABLED = "disabled";
	public static final String USER_STATUS_REGEX =  "^" + USER_STATUS_ACTIVE + "|" + USER_STATUS_PENDING + "|" + USER_STATUS_BLOCKED + "|" + USER_STATUS_DISABLED + "$";
	public static final String USER_ID_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// Constants related to Identity Provider Policy Configuration
	public static final String IDP_POLICY_DEFAULT_USER_STATUS_KEY = "def_user_status";
	public static final String IDP_POLICY_MAX_LOGIN_FAILURES_KEY = "max_login_fail";
	public static final String IDP_POLICY_DEFAULT_USER_STATUS_VALUE = USER_STATUS_PENDING;
	public static final int IDP_POLICY_MAX_LOGIN_FAILURES_VALUE = 5;


	public static final String TOKEN_TTL_OVERRIDE = "TOKEN_TTL_OVERRIDE";

	public static final long MAX_REQUEST_LATENCY_MILLIS = 5000; // if a request takes this long, we want to know.

	public static final String PROVIDER_AUTH_TYPE = "auth_type";
	public static final String SAML_CONFIG = "saml_config";

}
