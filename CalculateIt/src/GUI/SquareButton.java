package GUI;
import javax.swing.JButton;
import java.awt.Dimension;

public class SquareButton extends JButton {
    private int size;

    public SquareButton(String text, int size) {
        super(text);
        this.size = size;
        setFocusable(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}
