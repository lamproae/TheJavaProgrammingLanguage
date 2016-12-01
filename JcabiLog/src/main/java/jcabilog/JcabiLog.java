package jcabilog;

import com.jcabi.log.Logger;

public class JcabiLog {
    public JcabiLog() {
        Logger.debug(this, "method #bar(%d) was called", 1234);
    }
}
