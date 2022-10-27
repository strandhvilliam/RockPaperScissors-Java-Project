import javax.swing.*;

public enum Choice {
    ROCK("src/icons/icons8_rock_126px.png"),
    PAPER("src/icons/icons8_wallpaper_roll_126px.png"),
    SCISSORS("src/icons/icons8_cut_126px.png");

    private final String iconPath;

    Choice(String imageIcon) {
        this.iconPath = imageIcon;
    }

    public ImageIcon getIcon() {
        ImageIcon imageIcon = new ImageIcon(iconPath);
        return imageIcon;
    }


}


