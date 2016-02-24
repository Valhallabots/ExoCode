package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.drive.ReverseDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public final Joystick lStick = new Joystick(0), rStick = new Joystick(1);
	
    private final JoystickButton toggleDriveButton = new JoystickButton(rStick, 2);
    
    public OI() {
    	toggleDriveButton.toggleWhenPressed(new ReverseDrive());
    }
}

