package spring.rest.exceptionHandling;

public class NoSuchEmployeeExceptionData {
    private String info;

    public NoSuchEmployeeExceptionData(String info) {
        this.info = info;
    }

    public NoSuchEmployeeExceptionData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
