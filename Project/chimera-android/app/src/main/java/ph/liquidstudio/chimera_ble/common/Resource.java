package ph.liquidstudio.chimera_ble.common;

import android.support.annotation.Nullable;

/**
 * Created by eugene.p.lozada on 2/3/18.
 */

public class Resource<T> {

    public static enum Status{
        IN_PROGRESS,
        SUCCESS,
        FAILED
    }

    private T data;
    private String message;
    private Status status;

    public Resource(Status status, T data, String message){
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> failed(String msg, @Nullable T data) {
        return new Resource<>(Status.FAILED, data, msg);
    }

    public static <T> Resource<T> inProgress(@Nullable T data) {
        return new Resource<>(Status.IN_PROGRESS, data, null);
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }
}
