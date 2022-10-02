package thread.safety;

public class LocalVariable {
    public static void main(String[] args) {
        LocalVariable localVariable = new LocalVariable();
        localVariable.safeMethod();
    }

    public void safeMethod() {
        int threadSafeInt = 0;
        threadSafeInt++;
    }
}
