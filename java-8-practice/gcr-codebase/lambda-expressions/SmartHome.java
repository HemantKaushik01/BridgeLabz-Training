import java.util.function.Consumer;

public class SmartHome {
    public static void main(String[] args) {
        Consumer<String> motionTrigger = (room) -> System.out.println("Motion detected! Dimming lights to 50% in: " + room);
        Consumer<String> voiceTrigger = (room) -> System.out.println("Voice command received: Setting 'Party Mode' colors in: " + room);
        Consumer<String> nightMode = (room) -> System.out.println("It's 10 PM. Activating warm night-lights in: " + room);

        // Execute behaviors
        executePattern("Living Room", motionTrigger);
        executePattern("Kitchen", voiceTrigger);
    }

    public static void executePattern(String room, Consumer<String> pattern) {
        pattern.accept(room);
    }
}