package net.mcreator.demojavaplugin;

import net.mcreator.plugin.JavaPlugin;
import net.mcreator.plugin.Plugin;
import net.mcreator.plugin.events.workspace.MCreatorLoadedEvent;
import net.mcreator.ui.action.BasicAction;
import net.mcreator.ui.init.L10N;
import net.mcreator.ui.init.UIRES;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class DemoJavaPlugin extends JavaPlugin {

    private static final Logger LOG = LogManager.getLogger("Demo Java Plugin");

    public DemoJavaPlugin(Plugin plugin) {
        super(plugin);

        addListener(MCreatorLoadedEvent.class, event -> SwingUtilities.invokeLater(() -> {
            BasicAction demoAction = new BasicAction(event.getMCreator().getActionRegistry(),
                    L10N.t("plugin.demojava.menu.button"),
                    e -> event.getMCreator().getActionRegistry().buildWorkspace.doAction());
            demoAction.setIcon(UIRES.get("16px.play"));

            JMenu menu = new JMenu(L10N.t("plugin.demojava.menu.main"));
            menu.add(demoAction);

            event.getMCreator().getMainMenuBar().add(menu);
            event.getMCreator().getToolBar().addToRightToolbar(demoAction);
        }));

        LOG.info("Demo java plugin was loaded");
    }

}
