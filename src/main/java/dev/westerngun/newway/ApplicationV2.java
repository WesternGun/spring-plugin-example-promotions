package dev.westerngun.newway;

import dev.westerngun.domain.Group;
import dev.westerngun.domain.User;
import dev.westerngun.newway.serviceV2plugin.PromotionServiceV2Plugin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class ApplicationV2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("dev.westerngun.newway");
        PromotionServiceV2Plugin promotionServiceV2Plugin = context.getBean(PromotionServiceV2Plugin.class);
        User anyUser = new User();
        anyUser.setId("any member");
        anyUser.setGroup(Group.builder()
                .firstTimeBuyer(false)
                .build());
        User ftbMember = new User();
        ftbMember.setId("First time buyer");
        ftbMember.setGroup(Group.builder()
                .firstTimeBuyer(true)
                .build());
        promotionServiceV2Plugin.applyPromotions(anyUser, BigDecimal.valueOf(100));
        promotionServiceV2Plugin.applyPromotions(ftbMember, BigDecimal.valueOf(100));

        // expected result:
        //
        // For 15th anniversary, all members get 10% percentage discount during 10 days
        // For user any member, we give him 10% discount, final price: 90.0
        // For 15th anniversary, all members get 10% percentage discount during 10 days
        // For user First time buyer, we give him 10% discount, final price: 90.0
        // User First time buyer is first time member, we use discounts of 5 euros for first order, price after discount: 85.0
    }
}
