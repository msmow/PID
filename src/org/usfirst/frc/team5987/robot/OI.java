package org.usfirst.frc.team5987.robot;

import org.usfirst.frc.team5987.robot.commands.DriveByAnglesCommand;
import org.usfirst.frc.team5987.robot.commands.DriveByMetersCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    public static Joystick stickl = new Joystick(0);
    public static Joystick stickr = new Joystick(1);
    JoystickButton button1 = new JoystickButton(stickl, 3);	
    JoystickButton button2 = new JoystickButton(stickr, 3);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    public OI () {
    	button1.whenPressed(new DriveByMetersCommand(10.0));
    	button2.whenPressed(new DriveByAnglesCommand(15));
    }
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

