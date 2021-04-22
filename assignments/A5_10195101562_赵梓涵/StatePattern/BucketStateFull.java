/**
    创建状态接口的实现类：BucketStateFull
    实现接口：BucketState
 */

public class BucketStateFull implements BucketState{
    @Override
    public void press() {
        System.out.println("------BucketStateFull running！ Anction：pouring water！------");
    }
}
