package vptech.checkout.oldway.businessV1;

import vptech.checkout.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class PromotionApplierAllMember implements PromotionApplier {

    /**
     * Version 1 logic: all members get discounts
     * @param user
     * @param originalPrice
     */
    @Override
    public void promotions(User user, BigDecimal originalPrice) {
        log.info("For 15th anniversary, all members get 10% percentage discount during 10 days");
        log.info("For user {}, we give him 10% discount, saving: {}", user.getId(), originalPrice.multiply(BigDecimal.valueOf(0.1)));
    }
}
