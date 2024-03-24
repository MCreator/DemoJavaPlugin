package net.mcreator.demojavaplugin;

import net.mcreator.plugin.JavaPlugin;
import net.mcreator.plugin.Plugin;
import net.mcreator.plugin.events.workspace.MCreatorLoadedEvent;
import net.mcreator.ui.init.L10N;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class DemoJavaPlugin extends JavaPlugin {

    private static final Logger LOG = LogManager.getLogger("Demo Java Plugin");

    public DemoJavaPlugin(Plugin plugin) {
        super(plugin);

        addListener(MCreatorLoadedEvent.class, event -> {
            JMenu menu = new JMenu(L10N.t("plugin.demojava.menu.main"));

            JMenuItem menuItem = new JMenuItem(L10N.t("plugin.demojava.menu.button"));
            menuItem.addActionListener(e -> event.getMCreator().getActionRegistry().buildWorkspace.doAction());
            menu.add(menuItem);

            event.getMCreator().getMainMenuBar().add(menu);
        });

        LOG.info("Demo java plugin was loaded");
    }

}
