package dev.westerngun.oldway.businessV1;

import dev.westerngun.domain.User;

import java.math.BigDecimal;

public interface PromotionApplier {
    void promotions(User user, BigDecimal percent);
}
