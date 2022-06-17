package net.mcreator.demojavaplugin;

import net.mcreator.ui.MCreator;
import net.mcreator.ui.component.util.ComponentUtils;
import net.mcreator.ui.component.util.PanelUtils;
import net.mcreator.ui.init.L10N;
import net.mcreator.ui.modgui.ModElementGUI;
import net.mcreator.ui.validation.AggregatedValidationResult;
import net.mcreator.ui.validation.component.VTextField;
import net.mcreator.ui.validation.validators.RegistryNameValidator;
import net.mcreator.ui.validation.validators.TextFieldValidator;
import net.mcreator.workspace.elements.ModElement;

import javax.annotation.Nonnull;
import javax.swing.*;
import java.awt.*;

public class TestGUI extends ModElementGUI<Test> {
    private final VTextField text = new VTextField(20);

    public TestGUI(MCreator mcreator, @Nonnull ModElement modElement, boolean editingMode) {
        super(mcreator, modElement, editingMode);
        this.initGUI();
        super.finalizeGUI();
    }

    @Override
    protected void initGUI() {
        JPanel panel1 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel1.add(L10N.label("elementgui.test.text"));
        panel1.setOpaque(false);

        ComponentUtils.deriveFont(this.text, 16.0F);
        panel1.add(text);

        addPage(PanelUtils.totalCenterInPanel(panel1));
    }

    @Override
    protected AggregatedValidationResult validatePage(int i) {
        return new AggregatedValidationResult.PASS();
    }

    @Override
    protected void openInEditingMode(Test test) {
        text.setText(test.text);
    }

    @Override
    public Test getElementFromGUI() {
        Test test = new Test(modElement);
        test.text = text.getText();
        return test;
    }
}
