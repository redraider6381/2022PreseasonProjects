import edu.wpi.first.wpilibj.Timer;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Encoder;
public class Autonomous{
    private static int autoCount = 0;
    public static int ninetyTime = 2;
    private static Timer autoTimer = new Timer();

    private Encoder leftEncoder;
    private Encoder rightEncoder;

    public static boolean SimpleAuto(){
        switch(autoCount) {
            case 0:
                // forward
                autoTimer.start();
                Components.backLeftEncoder.set(0.5);
                Components.frontLeftEncoder.set(0.5);
                Components.backRightEncoder.set(0.5);
                Components.backRightEncoder.set(0.5);
               
                autoCount++;

            break;

            case 1:
            if (autoTimer.get() >= ninetyTime){
                autoTimer.start();
                // turn right
                Components.backLeftEncoder.set(0.5);
                Components.frontLeftEncoder.set(0.5);
                Components.backRightEncoder.set(-0.5);
                Components.backRightEncoder.set(-0.5);

                
                autoCount++;

            break;
            }

            case 2:
            if (autoTimer.get() >= ninetyTime){
                autoTimer.start();
                // forward
                Components.backLeftEncoder.set(0.5);
                Components.frontLeftEncoder.set(0.5);
                Components.backRightEncoder.set(0.5);
                Components.backRightEncoder.set(0.5);
                
                autoCount++;

            break;
            }

            case 3:
            if (autoTimer.get() >= ninetyTime){
                autoTimer.start();
                // turn right
                Components.backLeftEncoder.set(0.5);
                Components.frontLeftEncoder.set(0.5);
                Components.backRightEncoder.set(-0.5);
                Components.backRightEncoder.set(-0.5);
                
                autoCount++;

            break;
            }
            
            case 4:
            if (autoTimer.get() >= ninetyTime){
                autoTimer.start();
                // forward
                Components.backLeftEncoder.set(0.5);
                Components.frontLeftEncoder.set(0.5);
                Components.backRightEncoder.set(0.5);
                Components.backRightEncoder.set(0.5);
                
                autoCount++;

            break;
            }

            case 5:
            if (autoTimer.get() >= ninetyTime){
                autoTimer.start();
                // turn right
                Components.backLeftEncoder.set(0.5);
                Components.frontLeftEncoder.set(0.5);
                Components.backRightEncoder.set(-0.5);
                Components.backRightEncoder.set(-0.5);
                
                autoCount++;

            break;
            }
            
            case 6:
            if (autoTimer.get() >= ninetyTime){
                autoTimer.start();
                // forward
                Components.backLeftEncoder.set(0.5);
                Components.frontLeftEncoder.set(0.5);
                Components.backRightEncoder.set(0.5);
                Components.backRightEncoder.set(0.5);
                
                autoCount++;

            break;
            }
        }
    }
    public static boolean ComplexAuto(){
        leftEncoder = new Encoder(0,1);

        leftEncoder.setDistancePerPulse(MATH.PI / 60.0);
        rightEncoder.setDistancePerPulse(MATH.PI / 60.0);
    }
}