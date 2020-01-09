package vptech.checkout.newway.config;

import vptech.checkout.newway.businessV2plugin.PromotionApplierPlugin;
import vptech.checkout.newway.businessV2plugin.PromotionApplierPluginAllMembers;
import vptech.checkout.newway.businessV2plugin.PromotionApplierPluginNewMember;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.config.EnablePluginRegistries;

/**
 * The only downside: seems that Spring plugins cannot find plugin beans if not defined explictly in
 * configuration class.
 */
@Configuration
@EnablePluginRegistries({
        PromotionApplierPlugin.class
})
public class PluginsRegistry {
    @Bean
    public PromotionApplierPluginAllMembers promotionApplierPluginAllMembers() {
        return new PromotionApplierPluginAllMembers();
    }

    @Bean
    public PromotionApplierPluginNewMember promotionApplierPluginNewMember() {
        return new PromotionApplierPluginNewMember();
    }
}
