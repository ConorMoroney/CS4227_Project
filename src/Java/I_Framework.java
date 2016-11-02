package Java;

import java.awt.event.ActionEvent;

/**
 * Created by Conor on 28-Oct-16.
 */
interface I_Framework {

    void service();
    void event(ActionEvent event, String user);
    String access_internals();
}
