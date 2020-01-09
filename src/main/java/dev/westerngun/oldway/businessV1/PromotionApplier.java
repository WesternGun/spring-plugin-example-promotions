package vptech.checkout.oldway.businessV1;

import vptech.checkout.domain.User;

import java.math.BigDecimal;

public interface PromotionApplier {
    void promotions(User user, BigDecimal percent);
}
