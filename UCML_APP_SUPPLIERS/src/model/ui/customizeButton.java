/**
 * 
 */
package model.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

/**
 * @author ok
 *
 */
public class customizeButton extends Button {

	private final String FONT_PATH  = "./data/kenvector_future.ttf";
	private final String BUTTON_PRESSED_STYLE = 
			"-fx-ackground-color: transparent; -fix-background-image: "
			+ "url('file:./data/grey_button15.png')";
	private final String BUTTON_RELEASE_STYLE = 
			"-fx-ackground-color: transparent; -fix-background-image: "
					+ "url('file:./data/grey_button15.png')";
	
	public customizeButton(String txt)
	{
		this.setText(txt);
	setButtonFont();
	this.setPrefHeight(49);
	this.setPrefWidth(190);
	this.setStyle(BUTTON_PRESSED_STYLE);
	initializeButtonListeners();
}

private void setButtonFont()
{
	try {
		this.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private void setButtonPressedStyle()
{
	this.setStyle(BUTTON_PRESSED_STYLE);
	this.setPrefHeight(45);
	this.setLayoutY(getLayoutY() + 4);
	
}
private void setButtonReleasedStyle()
{
	this.setStyle(BUTTON_RELEASE_STYLE);
	this.setPrefHeight(49);
	this.setLayoutY(getLayoutY() - 4);
}

private void initializeButtonListeners()
{
	setOnMousePressed(e-> {
		if(e.getButton().equals(MouseButton.PRIMARY))
		{
			setButtonPressedStyle();
		}
	});
	setOnMouseReleased(e-> {
		if(e.getButton().equals(MouseButton.PRIMARY))
		{
			setButtonReleasedStyle();
		}
	});
	setOnMouseEntered(e-> {
		setEffect(new DropShadow());
	});
	setOnMouseExited(e-> {
		setEffect(null);
	});
}
}
