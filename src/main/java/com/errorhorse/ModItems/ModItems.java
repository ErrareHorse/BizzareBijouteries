package ModItems;

import com.errorhorse.bizzarebijouteries.BizzareBijouteries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BizzareBijouteries.MODID);

    public static final DeferredItem<Item> BLACKSTONEMIRROR = ITEMS.register("blackstonemirror",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}