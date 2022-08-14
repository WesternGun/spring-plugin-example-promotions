package dev.westerngun.newway.serviceV2plugin;

import dev.westerngun.newway.businessV2plugin.PromotionApplierPlugin;
import dev.westerngun.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionServiceV2Plugin {
    @Autowired
    private final PluginRegistry<PromotionApplierPlugin, User> pluginRegistry;

    /**
     * This service will never be changed due to usage of plugins.
     * And plugins can be unit-tested.
     *
     * @param user
     * @param originalPrice
     */
    public void applyPromotions(User user, BigDecimal originalPrice) {
        // getPluginsFor(): call "supports()" method before applying the plugin(classify and use plugin)
        // getPlugins(): does not call "supports()", indistingushly applies all plugins
        List<PromotionApplierPlugin> plugins = pluginRegistry.getPluginsFor(user);
        // you can also use "getPluginsFor(User, List<Plugins>)" to pre-filter a series of plugins to apply;
        // classification on "user" will also be applied

        // chaining results.
        // plugins supports ordering with @Order. Not shown in this project TODO
        BigDecimal result = originalPrice;
        for (PromotionApplierPlugin plugin: plugins){
            result = plugin.promotions(user, result);
        }
    }


}
