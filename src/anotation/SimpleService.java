package anotation;
@Service(name = "Simple")
public class SimpleService {
    @Init
    public void initService(){
        System.out.println(SimpleService.class.getSimpleName() + "  init");
    }
    public void one(){
        System.out.println();
    }
}
