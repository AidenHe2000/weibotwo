/**
    创建饮水机实体类：WaterDispenser
 */
public class WaterDispenser {
    private int capacity = 5;
    private BucketState bucketState;
 
    public WaterDispenser(BucketState bucketState) {
        this.bucketState = bucketState;
    }
    
    public void press() {
        capacity--;
        if (capacity <= 0) {
            this.bucketState = new BucketStateNull();
        }
        bucketState.press();
    }
}