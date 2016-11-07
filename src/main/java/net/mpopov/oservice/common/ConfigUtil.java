package net.mpopov.oservice.common;

public class ConfigUtil {
    public static final int DEFAUL_THUMBNAIL_WIDTH = 125;

    public static final int DEFAUL_THUMBNAIL_HEIGH = 84;

    private int recordsPerAdminPage;

    private int recordsPerClientPage;

    public void setRecordsPerAdminPage(int recordsPerAdminPage) {
        this.recordsPerAdminPage = recordsPerAdminPage;
    }

    public int getRecordsPerAdminPage() {
        return recordsPerAdminPage;
    }

    public int getRecordsPerClientPage() {
        return recordsPerClientPage;
    }

    public void setRecordsPerClientPage(int recordsPerClientPage) {
        this.recordsPerClientPage = recordsPerClientPage;
    }

}
