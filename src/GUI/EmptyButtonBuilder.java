package GUI;

/**
 * Created by colmm on 29/10/2016.
 */
public class EmptyButtonBuilder implements I_ButtonBuilder {

    private Button button;

    public EmptyButtonBuilder()
    {
        this.button = new Button();
    }

    public void buildButtonTitle()
    {
        button.setButtonTitle("");
    }

    public void buildButtonXLoc()
    {
        button.setButtonXLocation(0);
    }

    public void buildButtonYLoc()
    {
        button.setButtonYLocation(0);
    }

    public void buildButtonXSize()
    {
        button.setButtonXSize(0);
    }

    public void buildButtonYSize()
    {
        button.setButtonYSize(0);
    }

    public Button getButton()
    {
        return this.button;
    }
}
