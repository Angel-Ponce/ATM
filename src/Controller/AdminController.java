package Controller;

import Entity.User;
import Others.Helper;
import View.View;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

        View.createUserView.save.addActionListener((ae) -> {
            String name = View.createUserView.name.getText();
            String lastName = View.createUserView.lastName.getText();
            String email = View.createUserView.email.getText();
            String numberCard = View.createUserView.numberCard.getText();
            String pin = View.createUserView.pin.getText();
            String initialAmount = View.createUserView.initialAmount.getText();
            String maximumAmount = View.createUserView.maximumAmount.getText();
            File pick = View.createUserView.fileChooser.getSelectedFile();
            String age = View.createUserView.age.getText();
            if (!name.isEmpty() && !lastName.isEmpty()) {
                if (!email.isEmpty()) {
                    if (numberCard.matches("\\d+")) {
                        if (pin.matches("\\d+")) {
                            if (initialAmount.matches("\\d+")) {
                                if (maximumAmount.matches("\\d+")) {
                                    if (pick != null) {
                                        try {
                                            BufferedImage buffer = ImageIO.read(pick);
                                            boolean moved = ImageIO.write(buffer, "png", new File(System.getProperty("user.dir") + "/src/Resources/" + pick.getName()));
                                            if (moved) {
                                                User user = new User(Integer.valueOf(numberCard), Integer.valueOf(initialAmount), Integer.valueOf(maximumAmount), name, lastName, Integer.valueOf(age), email, Integer.valueOf(pin), null, "/Resources/" + pick.getName());
                                                if (Model.AdminModel.addUser(user)) {
                                                    Helper.success("User added successfly");
                                                    View.createUserView.name.setText("");
                                                    View.createUserView.lastName.setText("");
                                                    View.createUserView.email.setText("");
                                                    View.createUserView.age.setText("");
                                                    View.createUserView.numberCard.setText("");
                                                    View.createUserView.pin.setText("");
                                                    View.createUserView.initialAmount.setText("");
                                                    View.createUserView.maximumAmount.setText("");
                                                    View.createUserView.fileChooser.setSelectedFile(null);
                                                    View.createUserView.pick.setIcon(Helper.roundImage("/Resources/default.png", 256, 256));
                                                } else {
                                                    Helper.error("The user cant be added");
                                                }
                                            } else {
                                                Helper.error("An error ocurred while we move the pick");
                                            }
                                        } catch (IOException ex) {
                                            Helper.error("An error ocurred while we load the pick");
                                        }
                                    } else {
                                        Helper.error("The pick is required");
                                    }
                                } else {
                                    Helper.error("The maximum amount is a integer number, and is required");
                                }
                            } else {
                                Helper.error("The initial amount is a integer number, and is required");
                            }
                        } else {
                            Helper.error("The pin is a number, and is required");
                        }
                    } else {
                        Helper.error("The number card is a number, and is required");
                    }
                } else {
                    Helper.error("The email is required");
                }
            } else {
                Helper.error("The name and lastname are required");
            }
        });
    }

    public void addUser() {
        View.atmView.content.removeAll();
        View.createUserView.name.setText("");
        View.createUserView.lastName.setText("");
        View.createUserView.email.setText("");
        View.createUserView.age.setText("");
        View.createUserView.numberCard.setText("");
        View.createUserView.initialAmount.setText("");
        View.createUserView.maximumAmount.setText("");
        View.createUserView.pin.setText("");
        View.createUserView.pick.setIcon(Helper.roundImage("/Resources/default.png", 256, 256));
        View.createUserView.fileChooser.setSelectedFile(null);
        View.atmView.content.add(View.createUserView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }

}
