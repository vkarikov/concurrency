package thread.safety;

public class LocalObjectReference {

    private String value;

    public void safeMethod(){
        LocalObjectReference localObject = new LocalObjectReference();
        localObject.callMethod();
        method2(localObject);
    }

    private void callMethod() {

    }

    private void method2(LocalObjectReference localObject){
        localObject.setValue("value");
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
