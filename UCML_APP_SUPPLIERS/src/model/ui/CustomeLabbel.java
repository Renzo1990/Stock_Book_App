/**
 * 
 */
package model.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

/**
 * @author ok
 *
 */
public class CustomeLabbel extends Label {

	private static final String FONT_PATH = "./data/font.ttf";
	
	public CustomeLabbel(String msg)
	{
		setPrefWidth(150);
		setPrefHeight(30);
		BackgroundImage back = new BackgroundImage(new Image("file:./data/blue_button00.png", 150, 30, false, true), 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		setBackground(new Background(back));
		setAlignment(Pos.CENTER);
		//setPadding(new Insets(10, 10, 10, 10));
       setLabelFont();
		setText(msg);
	}
	private void setLabelFont()
	{
		try {
			this.setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 16));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
