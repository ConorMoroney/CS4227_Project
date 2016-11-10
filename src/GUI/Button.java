package GUI;

/**
 * Created by colmm on 29/10/2016.
 */
public class Button implements I_ButtonPlan
{
    private String buttonTitle;
    private int buttonXLoc;
    private int buttonYLoc;
    private int buttonXSize;
    private int buttonYSize;

    @Override
    public void setButtonTitle(String title) {
        buttonTitle = title;
    }

    public String getButtonTitle() {    return buttonTitle; }

    @Override
    public void setButtonXLocation(int xLoc) {
        buttonXLoc = xLoc;
    }

    public int getButtonXLocation() {   return buttonXLoc;  }

    @Override
    public void setButtonYLocation(int yLoc) {
        buttonYLoc = yLoc;
    }

    public int getButtonYLocation() {   return buttonYLoc;  }

    @Override
    public void setButtonXSize(int xSize) {
        buttonXSize = xSize;
    }

    public int getButtonXSize() {   return buttonXSize; }

    @Override
    public void setButtonYSize(int ySize) {
        buttonYSize = ySize;
    }

    public int getButtonYSize() {   return buttonYSize; }
}
