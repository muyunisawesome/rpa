package util;

import javax.swing.*;
import java.awt.*;

import entity.User;

/**
 *
 */
public class MyListCellRender extends JLabel implements ListCellRenderer {
  @Override
  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    setIcon(new ImageIcon(ResourceLoad.load(
            ((User)value).getFileName())
    ));
    setText(((User)value).getName());
    return this;
  }
}
