package frc.robot.lib.joystick;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.command_status.DriveCommand;
import frc.robot.lib.util.DataLogger;

/**
 * An abstract class that forms the base of joystick controls.
 */
public abstract class JoystickControlsBase 
{
    protected final Joystick mStick;

    public static double kJoystickDeadzone = 0.2;   // deadzone at center of joystick extends from +/-kJoystickDeadzone

    protected JoystickControlsBase() 
    {
        mStick = new Joystick(0);
    }

    // DRIVER CONTROLS
    public abstract DriveCommand getDriveCommand();	// mapping from joystick controls to DriveSignal
    
    public boolean getButton(int _num) { return mStick.getRawButton(_num); }
    
	private final DataLogger logger = new DataLogger()
    {
        @Override
        public void log()
        {
            put("Joystick/Throttle", mStick.getRawAxis(0) );
            put("Joystick/Turn", mStick.getRawAxis(1) );
            int buttons = 0;
            for (int button=1; button<=16; button++)
            {
                buttons |= (getButton(button) ? 1 : 0) << (button-1);
            }
            put("Joystick/buttons", buttons);
        }
    };
    
    public DataLogger getLogger() { return logger; }

}
