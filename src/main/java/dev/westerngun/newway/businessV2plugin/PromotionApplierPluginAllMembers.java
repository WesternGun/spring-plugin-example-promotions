package dev.westerngun.newway.businessV2plugin;

import dev.westerngun.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class PromotionApplierPluginAllMembers implements PromotionApplierPlugin {
    @Override
    public BigDecimal promotions(User user, BigDecimal originalPrice) {
        BigDecimal deduction = originalPrice.multiply(BigDecimal.valueOf(0.1));
        log.info("For 15th anniversary, all members get 10% percentage discount during 10 days");
        log.info("For user {}, we give him 10% discount, final price: {}", user.getId(), originalPrice.subtract(deduction));
        return originalPrice.subtract(deduction);
    }

    /**
     * Classfier method to define if user meets some criteria to use promotion
     * Because all members use this promotion, we just return true
     * @param delimiter
     * @return
     */
    @Override
    public boolean supports(User delimiter) {
        return true;
    }
}
