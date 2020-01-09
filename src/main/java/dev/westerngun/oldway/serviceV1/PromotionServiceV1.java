package vptech.checkout.oldway.serviceV1;

import vptech.checkout.oldway.businessV1.PromotionApplier;
import vptech.checkout.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PromotionServiceV1 {
    @Autowired
    private final PromotionApplier promotionApplier;

    /**
     * Legacy way without plugins.
     *
     * If we need to change business logic, this service is prune to changes
     * and will gets complicated. And so as tests of this service.
     *
     * @param user
     * @param originalPrice
     */
    public void applyPromotion(User user, BigDecimal originalPrice) {
        promotionApplier.promotions(user, originalPrice);
    }
}
