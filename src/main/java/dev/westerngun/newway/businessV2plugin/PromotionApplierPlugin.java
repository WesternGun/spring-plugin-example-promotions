package vptech.checkout.newway.businessV2plugin;

import vptech.checkout.domain.User;
import org.springframework.plugin.core.Plugin;

import java.math.BigDecimal;

public interface PromotionApplierPlugin extends Plugin<User> {
    BigDecimal promotions(User user, BigDecimal originalPrice);
}
