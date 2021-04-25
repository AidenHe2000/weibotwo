/**
    使用StatePatternDemo类演示接水饮水机状态改变：StatePatternDemo
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        WaterDispenser waterDispenser =new WaterDispenser(new BucketStateFull());
        for(int i=0;i<5;i++){
            waterDispenser.press();
        }
    }
}