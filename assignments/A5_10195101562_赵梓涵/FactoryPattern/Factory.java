/**
    唯一的工厂，可以生产两种型号的处理器核，在内部判断    
    实现接口：SingleCore   
 */
public class Factory{
    @Override
    public void CreateSingleCore(String ctype) {
        if(ctype == 'COREA') //工厂内部判断    
            return new SingleCoreA(); //生产核A    
        else if(ctype == 'COREB')    
            return new SingleCoreB(); //生产核B    
        else    
            return NULL;   
    }
    
}