package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * Created by eugene.p.lozada on 1/26/18.
 */

public class UiThreadExecutor implements Executor {

    private final Handler handler = new Handler(Looper.getMainLooper());

    private static final UiThreadExecutor instance = new UiThreadExecutor();

    public static UiThreadExecutor instance() {
        return instance;
    }

    @Override
    public void execute(@NonNull Runnable command) {
        handler.post(command);
    }
}