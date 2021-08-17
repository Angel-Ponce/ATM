package Controller;

import Others.Helper;
import View.View;
import java.io.File;

/**
 *
 * @author samyc
 */
public class AdminController implements Controller {

    public AdminController() {
        events();
    }

    @Override
    public void start() {
    }

    @Override
    public void end() {
    }

    @Override
    public void events() {
        View.createUserView.choosePick.addActionListener(((ae) -> {
            int opened = View.createUserView.fileChooser.showOpenDialog(View.createUserView);
            if (opened == 0) {
                File file = View.createUserView.fileChooser.getSelectedFile();
                if (file != null) {
                    if (file.getName().matches(".*\\.(png|PNG|jpe?g|JPE?G|)")) {
                        View.createUserView.pick.setIcon(Helper.roundImage(file, 256, 256));
                    } else {
                        Helper.error("Error, the file would be a Image");
                    }
                }
            }
        }));
    }

    public void addUser() {
        View.atmView.content.removeAll();
        View.createUserView.name.setText("");
        View.createUserView.numberCard.setText("");
        View.createUserView.initialAmount.setText("");
        View.createUserView.maximumAmount.setText("");
        View.createUserView.pin.setText("");
        View.createUserView.pick.removeAll();
        View.atmView.content.add(View.createUserView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }

}
