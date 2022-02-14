package anotation;
@Service(name = "Laze")
public class LazyService {
    @Init
    public void initLazy() throws Exception{
        System.out.println(LazyService.class.getSimpleName() + " init");
    };
}
