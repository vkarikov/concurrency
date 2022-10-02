package thread.safety.immutability;

public class ThreadSafeCalculator {
    private ImmutableValue currentValue = null;

    public synchronized ImmutableValue getValue(){
        return currentValue;
    }

    public synchronized void setValue(ImmutableValue newValue){
        this.currentValue = newValue;
    }

    public synchronized  void add(int newValue){
        this.currentValue = this.currentValue.add(newValue);
    }
}
