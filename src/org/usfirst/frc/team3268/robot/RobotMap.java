package org.usfirst.frc.team3268.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class RobotMap {
    public static final CANTalon leftDrive = new CANTalon(1), rightDrive = new CANTalon(2);
    
    public static final DoubleSolenoid solenoid = new DoubleSolenoid(7, 6);
    
    public static final Talon intake = new Talon(2);
    public static final Talon firingRight = new Talon(0), firingLeft = new Talon(1);
    public static final Servo firingServo = new Servo(4);
    
    public static final Gyro gyro = new AnalogGyro(1);
    
    public static final PWM ledR = new PWM(5), ledG = new PWM(6), ledB = new PWM(7);
    public static final DigitalOutput ledThrough = new DigitalOutput(0);
}
