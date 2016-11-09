package GUI;

/**
 * Created by colmm on 29/10/2016.
 */
public class LogInButtonBuilder implements I_ButtonBuilder
{
    private final Button button;

    public LogInButtonBuilder()
    {
        this.button = new Button();
    }

    public void buildButtonTitle()
    {
        button.setButtonTitle("Log In");
    }

    public void buildButtonXLoc()
    {
        button.setButtonXLocation(183);
    }

    public void buildButtonYLoc()
    {
        button.setButtonYLocation(230);
    }

    public void buildButtonXSize()
    {
        button.setButtonXSize(85);
    }

    public void buildButtonYSize()
    {
        button.setButtonYSize(30);
    }

    public Button getButton()
    {
        return this.button;
    }
}
