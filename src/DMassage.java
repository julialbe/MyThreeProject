import javax.swing.*;
import java.awt.*;

/**
 * Created by juli on 11/30/16.
 */
public class DMassage {
    JDialog jDialog;
    public DMassage(String label_one) {
        jDialog = new JDialog();
        jDialog.setVisible(true);
        jDialog.setSize(200, 80);
        jDialog.setLocation(200, 200);
        jDialog.setLayout(new FlowLayout());
        jDialog.setTitle("Error");
        JLabel jLabel = new JLabel(label_one);
        jDialog.add(jLabel);

    }
}
