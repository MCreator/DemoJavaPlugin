package net.mcreator.demojavaplugin;

import net.mcreator.plugin.JavaPlugin;
import net.mcreator.plugin.Plugin;
import net.mcreator.ui.MCreator;
import net.mcreator.ui.init.L10N;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class DemoJavaPlugin extends JavaPlugin {

    private static final Logger LOG = LogManager.getLogger("Demo Java Plugin");

    public DemoJavaPlugin(Plugin plugin) {
        super(plugin);

        LOG.info("Demo java plugin was loaded");
    }

    @Override
    public void eventNewMCreator(MCreator mcreator) {
        JMenu menu = new JMenu(L10N.t("plugin.demojava.menu.main"));

        JMenuItem menuItem = new JMenuItem(L10N.t("plugin.demojava.menu.button"));
        menuItem.addActionListener(e -> mcreator.getActionRegistry().buildWorkspace.doAction());
        menu.add(menuItem);

        mcreator.getMainMenuBar().add(menu);
    }

}
