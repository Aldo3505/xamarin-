package ph.liquidstudio.chimera_ble.common;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by eugene.p.lozada on 2/4/18.
 */

public class FormatUtils {

    private static DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM);
    public static String formatTimeStamp(long millis) {
        return format.format(new Date(millis));
    }
}
