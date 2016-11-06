package GUI;

/**
 * Created by colmm on 29/10/2016.
 */
public interface I_ButtonBuilder
{
    void buildButtonTitle();
    void buildButtonXLoc();
    void buildButtonYLoc();
    void buildButtonXSize();
    void buildButtonYSize();

    Button getButton();
}
