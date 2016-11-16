package Test;

import GUI.Button;
import GUI.ButtonEngineer;
import GUI.EmptyButtonBuilder;
import GUI.I_ButtonBuilder;

/**
 * Created by colmm on 29/10/2016.
 */
class TestButtonBuilder
{
    public static void main(String[] args)
    {
        I_ButtonBuilder exitButton = new EmptyButtonBuilder();

        ButtonEngineer buttonEngineer = new ButtonEngineer(exitButton);
        buttonEngineer.makeButton();

        Button firstButton = buttonEngineer.getButton();
        firstButton.setButtonXLocation(15);

        System.out.println("Button Built.");
        System.out.println("Button Title: " + firstButton.getButtonTitle());
        System.out.println("Button xLoc: " + firstButton.getButtonXLocation());
        System.out.println("Button yLoc: " + firstButton.getButtonYLocation());
        System.out.println("Button xSize: " + firstButton.getButtonXSize());
        System.out.println("Button ySize: " + firstButton.getButtonYSize());
    }
}