package expo.modules.interfaces.permissions;

public enum PermissionsStatus {
    GRANTED(PermissionsResponse.GRANTED_KEY),
    UNDETERMINED("undetermined"),
    DENIED("denied");
    
    private final String status;

    public String getStatus() {
        return this.status;
    }

    private PermissionsStatus(String str) {
        this.status = str;
    }
}
