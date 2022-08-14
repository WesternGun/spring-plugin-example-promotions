package dev.westerngun.newway.businessV2plugin;

import dev.westerngun.domain.User;
import org.springframework.plugin.core.Plugin;

import java.math.BigDecimal;

public interface PromotionApplierPlugin extends Plugin<User> {
    BigDecimal promotions(User user, BigDecimal originalPrice);
}
