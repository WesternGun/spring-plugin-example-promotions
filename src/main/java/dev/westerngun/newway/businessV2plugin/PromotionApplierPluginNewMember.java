package vptech.checkout.newway.businessV2plugin;

import vptech.checkout.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class PromotionApplierPluginNewMember implements PromotionApplierPlugin {
    @Override
    public BigDecimal promotions(User user, BigDecimal originalPrice) {
        BigDecimal priceAfterDiscount = BigDecimal.ZERO;
        if (originalPrice.compareTo(BigDecimal.valueOf(5)) > 0) {
            priceAfterDiscount = originalPrice.subtract(BigDecimal.valueOf(5));
            log.info("User {} is first time member, we use discounts of 5 euros for first order, price after discount: {}",
                    user.getId(), priceAfterDiscount);

        } else {
            log.info("Price cannot be deduced more by first time buyer discount");
            priceAfterDiscount = originalPrice;
        }
        return priceAfterDiscount;
    }

    /**
     * Classfier method to decide if user meets some criteria to use promotion
     * Only first time buyer can use this promotion
     * @param delimiter
     * @return
     */
    @Override
    public boolean supports(User delimiter) {
        if (delimiter.getGroup().getFirstTimeBuyer()) {
            log.info("User {} is first time buyer, applying promotion of FTB", delimiter.getId());
            return true;
        } else {
            log.info("User {} is not first time buyer, ignoring promotion of FTB", delimiter.getId());
            return false;
        }
    }
}
