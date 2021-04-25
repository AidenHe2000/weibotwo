/**
    创建状态接口的实现类：BucketStateNull
    实现接口：BucketState
 */
public class BucketStateNull implements BucketState{
    @Override
    public void press() {
        System.out.println("------BucketStateNull running！ Anction：no water！------");
    }
}