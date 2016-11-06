package GUI;

/**
 * Created by colmm on 29/10/2016.
 */
public class ButtonEngineer
{
    private final I_ButtonBuilder i_buttonBuilder;

    public ButtonEngineer (I_ButtonBuilder i_buttonBuilder)
    {
        this.i_buttonBuilder = i_buttonBuilder;
    }

    public Button getButton()
    {
        return this.i_buttonBuilder.getButton();
    }

    public void makeButton()
    {
        this.i_buttonBuilder.buildButtonTitle();

        this.i_buttonBuilder.buildButtonXLoc();
        this.i_buttonBuilder.buildButtonYLoc();

        this.i_buttonBuilder.buildButtonXSize();
        this.i_buttonBuilder.buildButtonYSize();
    }
}
