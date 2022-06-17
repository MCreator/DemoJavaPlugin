package net.mcreator.demojavaplugin;

import net.mcreator.element.*;
import net.mcreator.plugin.JavaPlugin;
import net.mcreator.plugin.Plugin;
import net.mcreator.plugin.events.PreGeneratorsLoadingEvent;
import net.mcreator.ui.init.L10N;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mcreator.plugin.events.MCreatorLoadedEvent;

import javax.swing.*;

public class DemoJavaPlugin extends JavaPlugin {

    private static final Logger LOG = LogManager.getLogger("Demo Java Plugin");
    public static ModElementType<?> TEST;

    public DemoJavaPlugin(Plugin plugin) {
        super(plugin);

        addListener(MCreatorLoadedEvent.class, event -> {
            JMenu menu = new JMenu(L10N.t("plugin.demojava.menu.main"));

            JMenuItem menuItem = new JMenuItem(L10N.t("plugin.demojava.menu.button"));
            menuItem.addActionListener(e -> event.getMCreator().getActionRegistry().buildWorkspace.doAction());
            menu.add(menuItem);

            event.getMCreator().getMainMenuBar().add(menu);
        });
        addListener(PreGeneratorsLoadingEvent.class, event -> {
            /*
             * Shortcuts should use a-z characters. However, they are already all used by default mod element types.
             */
            TEST = ModElementTypeLoader.register(new ModElementType<>(
                    "test", '1', BaseType.OTHER, RecipeType.NONE, TestGUI::new, Test.class));
        });

        LOG.info("Demo java plugin was loaded");
    }

}
