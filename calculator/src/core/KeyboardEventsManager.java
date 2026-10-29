package core;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class KeyboardEventsManager implements KeyEventDispatcher {

    public KeyboardEventsManager() {
        KeyboardFocusManager
            .getCurrentKeyboardFocusManager()
            .addKeyEventDispatcher(this);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getID() != KeyEvent.KEY_PRESSED) {
            return false;
        }

        if (
            event.getKeyCode() == KeyEvent.VK_I &&
            event.isControlDown() &&
            event.isShiftDown()
        ) {

            System.out.println();

            return true;
        }

        return false;
    }

    public void unregister() {
        KeyboardFocusManager
            .getCurrentKeyboardFocusManager()
            .removeKeyEventDispatcher(this);
    }
}
