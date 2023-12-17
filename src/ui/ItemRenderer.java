package ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

/**
 * Renderização de ítens no JComboBox, utilizando a classe Item
 *
 * @author Diego Mendes Rodrigues
 */
public class ItemRenderer extends BasicComboBoxRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);
        if (value != null) {
            Item item = (Item) value;
            setText(item.getDescricao().toUpperCase());
        }
        if (index == -1) {
            Item item = (Item) value;
            setText(item.getCodigo());
        }
        return this;
    }
}
