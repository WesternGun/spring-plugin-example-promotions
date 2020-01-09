package vptech.checkout.oldway;

import vptech.checkout.domain.User;
import vptech.checkout.oldway.serviceV1.PromotionServiceV1;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class ApplicationV1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("vptech.checkout.oldway");
        PromotionServiceV1 promotionServiceV1 = context.getBean(PromotionServiceV1.class);
        User anyUser = new User();
        anyUser.setId("any member");
        promotionServiceV1.applyPromotion(anyUser, BigDecimal.valueOf(100));
    }
}
