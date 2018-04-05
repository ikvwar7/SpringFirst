package mypack;

import mypack.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        AccountService bean = applicationContext.getBean(AccountService.class);
        bean.printAll();
        bean.getTotalVolume();
        bean.getTotalOwnerVolume(1l);
        bean.multiplyAll(10.0);
        bean.multiplyOwner(1l, 10.0);
        bean.printAll();
    }
}
