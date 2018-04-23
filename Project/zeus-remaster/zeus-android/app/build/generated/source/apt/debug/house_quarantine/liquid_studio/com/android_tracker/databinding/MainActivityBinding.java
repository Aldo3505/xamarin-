package house_quarantine.liquid_studio.com.android_tracker.databinding;
import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MainActivityBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.menu, 15);
        sViewsWithIds.put(R.id.upload_progress3, 16);
        sViewsWithIds.put(R.id.guideline5, 17);
        sViewsWithIds.put(R.id.guideline6, 18);
        sViewsWithIds.put(R.id.guideline2, 19);
        sViewsWithIds.put(R.id.guideline3, 20);
        sViewsWithIds.put(R.id.guideline4, 21);
        sViewsWithIds.put(R.id.StatusLin, 22);
        sViewsWithIds.put(R.id.card_view, 23);
        sViewsWithIds.put(R.id.ConnectivityLin, 24);
        sViewsWithIds.put(R.id.WifiLin, 25);
        sViewsWithIds.put(R.id.BatteryView, 26);
        sViewsWithIds.put(R.id.BatterImage, 27);
        sViewsWithIds.put(R.id.linearLayoutCompat, 28);
        sViewsWithIds.put(R.id.waiting_bar, 29);
        sViewsWithIds.put(R.id.text_connect, 30);
        sViewsWithIds.put(R.id.list_beacons, 31);
        sViewsWithIds.put(R.id.menu, 32);
    }
    // views
    @NonNull
    public final android.widget.ImageView BatterImage;
    @NonNull
    public final android.support.v7.widget.CardView BatteryView;
    @NonNull
    public final android.support.v7.widget.LinearLayoutCompat ConnectivityLin;
    @NonNull
    public final android.widget.LinearLayout StatusLin;
    @NonNull
    public final android.widget.LinearLayout WifiLin;
    @NonNull
    public final android.widget.TextView activeText;
    @NonNull
    public final android.widget.FrameLayout batteryAlert;
    @NonNull
    public final android.widget.TextView batteryLevel;
    @NonNull
    public final com.github.clans.fab.FloatingActionButton cameraFab;
    @NonNull
    public final com.github.clans.fab.FloatingActionButton cameraFab1;
    @NonNull
    public final android.support.v7.widget.CardView cardView;
    @NonNull
    public final android.support.constraint.ConstraintLayout container;
    @NonNull
    public final android.widget.TextView delinqText;
    @NonNull
    public final android.support.constraint.Guideline guideline2;
    @NonNull
    public final android.support.constraint.Guideline guideline3;
    @NonNull
    public final android.support.constraint.Guideline guideline4;
    @NonNull
    public final android.support.constraint.Guideline guideline5;
    @NonNull
    public final android.support.constraint.Guideline guideline6;
    @NonNull
    public final android.widget.ImageView imageView2;
    @NonNull
    public final android.widget.TextView infoDel;
    @NonNull
    public final android.support.v7.widget.LinearLayoutCompat linearLayoutCompat;
    @NonNull
    public final android.support.v7.widget.RecyclerView listBeacons;
    @NonNull
    private final android.widget.FrameLayout mboundView8;
    @NonNull
    public final com.github.clans.fab.FloatingActionMenu menu;
    @NonNull
    public final com.github.clans.fab.FloatingActionMenu menu1;
    @NonNull
    public final android.support.design.widget.FloatingActionButton splashButton;
    @NonNull
    public final android.support.constraint.ConstraintLayout splashLayout;
    @NonNull
    public final android.widget.TextView textConnect;
    @NonNull
    public final android.widget.ProgressBar uploadProgress3;
    @NonNull
    public final com.github.clans.fab.FloatingActionButton verifyFab;
    @NonNull
    public final com.github.clans.fab.FloatingActionButton verifyFab1;
    @NonNull
    public final android.widget.ProgressBar waitingBar;
    @NonNull
    public final android.widget.TextView wifiLevel;
    // variables
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.MainHandler mHandler;
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel mModel;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MainActivityBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 33, sIncludes, sViewsWithIds);
        this.BatterImage = (android.widget.ImageView) bindings[27];
        this.BatteryView = (android.support.v7.widget.CardView) bindings[26];
        this.ConnectivityLin = (android.support.v7.widget.LinearLayoutCompat) bindings[24];
        this.StatusLin = (android.widget.LinearLayout) bindings[22];
        this.WifiLin = (android.widget.LinearLayout) bindings[25];
        this.activeText = (android.widget.TextView) bindings[7];
        this.activeText.setTag(null);
        this.batteryAlert = (android.widget.FrameLayout) bindings[11];
        this.batteryAlert.setTag(null);
        this.batteryLevel = (android.widget.TextView) bindings[12];
        this.batteryLevel.setTag(null);
        this.cameraFab = (com.github.clans.fab.FloatingActionButton) bindings[3];
        this.cameraFab.setTag(null);
        this.cameraFab1 = (com.github.clans.fab.FloatingActionButton) bindings[13];
        this.cameraFab1.setTag(null);
        this.cardView = (android.support.v7.widget.CardView) bindings[23];
        this.container = (android.support.constraint.ConstraintLayout) bindings[0];
        this.container.setTag(null);
        this.delinqText = (android.widget.TextView) bindings[5];
        this.delinqText.setTag(null);
        this.guideline2 = (android.support.constraint.Guideline) bindings[19];
        this.guideline3 = (android.support.constraint.Guideline) bindings[20];
        this.guideline4 = (android.support.constraint.Guideline) bindings[21];
        this.guideline5 = (android.support.constraint.Guideline) bindings[17];
        this.guideline6 = (android.support.constraint.Guideline) bindings[18];
        this.imageView2 = (android.widget.ImageView) bindings[9];
        this.imageView2.setTag(null);
        this.infoDel = (android.widget.TextView) bindings[2];
        this.infoDel.setTag(null);
        this.linearLayoutCompat = (android.support.v7.widget.LinearLayoutCompat) bindings[28];
        this.listBeacons = (android.support.v7.widget.RecyclerView) bindings[31];
        this.mboundView8 = (android.widget.FrameLayout) bindings[8];
        this.mboundView8.setTag(null);
        this.menu = (com.github.clans.fab.FloatingActionMenu) bindings[15];
        this.menu1 = (com.github.clans.fab.FloatingActionMenu) bindings[32];
        this.splashButton = (android.support.design.widget.FloatingActionButton) bindings[6];
        this.splashButton.setTag(null);
        this.splashLayout = (android.support.constraint.ConstraintLayout) bindings[1];
        this.splashLayout.setTag(null);
        this.textConnect = (android.widget.TextView) bindings[30];
        this.uploadProgress3 = (android.widget.ProgressBar) bindings[16];
        this.verifyFab = (com.github.clans.fab.FloatingActionButton) bindings[4];
        this.verifyFab.setTag(null);
        this.verifyFab1 = (com.github.clans.fab.FloatingActionButton) bindings[14];
        this.verifyFab1.setTag(null);
        this.waitingBar = (android.widget.ProgressBar) bindings[29];
        this.wifiLevel = (android.widget.TextView) bindings[10];
        this.wifiLevel.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
        mCallback4 = new android.databinding.generated.callback.OnClickListener(this, 4);
        mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 3);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.handler == variableId) {
            setHandler((house_quarantine.liquid_studio.com.android_tracker.main.MainHandler) variable);
        }
        else if (BR.model == variableId) {
            setModel((house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.MainHandler Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.MainHandler getHandler() {
        return mHandler;
    }
    public void setModel(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel Model) {
        updateRegistration(0, Model);
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel getModel() {
        return mModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModel((house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModel(house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.delinquent) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.connected) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.batteryLevel) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int androidDatabindingDynamicUtilSafeUnboxModelDelinquentSplashButtonAndroidColorHoloRedDarkSplashButtonAndroidColorHoloGreenDark = 0;
        java.lang.String modelConnectedWifiLevelAndroidStringConnectedWifiLevelAndroidStringDisconnected = null;
        house_quarantine.liquid_studio.com.android_tracker.main.MainHandler handler = mHandler;
        android.graphics.drawable.Drawable modelConnectedImageView2AndroidDrawableConnectedImageView2AndroidDrawableConnectivityOff = null;
        boolean androidDatabindingDynamicUtilSafeUnboxModelDelinquent = false;
        house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel model = mModel;
        boolean modelBatteryLevelInt25 = false;
        float modelBatteryLevel = 0f;
        java.lang.String modelConnectedActiveTextAndroidStringAppLabelScanningActiveTextAndroidStringAppLabelAwaitConnection = null;
        boolean modelConnected = false;
        int modelBatteryLevelInt25ViewINVISIBLEViewVISIBLE = 0;
        int androidDatabindingDynamicUtilSafeUnboxModelDelinquentViewVISIBLEViewINVISIBLE = 0;
        java.lang.Boolean modelDelinquent = null;
        java.lang.String batteryLevelAndroidStringBatteryLevelFormatModelBatteryLevel = null;
        int modelConnectedViewINVISIBLEViewVISIBLE = 0;

        if ((dirtyFlags & 0x3dL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (model != null) {
                        // read model.batteryLevel
                        modelBatteryLevel = model.getBatteryLevel();
                    }


                    // read model.batteryLevel > 25
                    modelBatteryLevelInt25 = (modelBatteryLevel) > (25);
                    // read @android:string/battery_level_format
                    batteryLevelAndroidStringBatteryLevelFormatModelBatteryLevel = batteryLevel.getResources().getString(R.string.battery_level_format, modelBatteryLevel);
                if((dirtyFlags & 0x31L) != 0) {
                    if(modelBatteryLevelInt25) {
                            dirtyFlags |= 0x8000L;
                    }
                    else {
                            dirtyFlags |= 0x4000L;
                    }
                }


                    // read model.batteryLevel > 25 ? View.INVISIBLE : View.VISIBLE
                    modelBatteryLevelInt25ViewINVISIBLEViewVISIBLE = ((modelBatteryLevelInt25) ? (android.view.View.INVISIBLE) : (android.view.View.VISIBLE));
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (model != null) {
                        // read model.connected
                        modelConnected = model.isConnected();
                    }
                if((dirtyFlags & 0x29L) != 0) {
                    if(modelConnected) {
                            dirtyFlags |= 0x200L;
                            dirtyFlags |= 0x800L;
                            dirtyFlags |= 0x2000L;
                            dirtyFlags |= 0x80000L;
                    }
                    else {
                            dirtyFlags |= 0x100L;
                            dirtyFlags |= 0x400L;
                            dirtyFlags |= 0x1000L;
                            dirtyFlags |= 0x40000L;
                    }
                }


                    // read model.connected ? @android:string/connected : @android:string/disconnected
                    modelConnectedWifiLevelAndroidStringConnectedWifiLevelAndroidStringDisconnected = ((modelConnected) ? (wifiLevel.getResources().getString(R.string.connected)) : (wifiLevel.getResources().getString(R.string.disconnected)));
                    // read model.connected ? @android:drawable/connected : @android:drawable/connectivity_off
                    modelConnectedImageView2AndroidDrawableConnectedImageView2AndroidDrawableConnectivityOff = ((modelConnected) ? (getDrawableFromResource(imageView2, R.drawable.connected)) : (getDrawableFromResource(imageView2, R.drawable.connectivity_off)));
                    // read model.connected ? @android:string/app_label_scanning : @android:string/app_label_await_connection
                    modelConnectedActiveTextAndroidStringAppLabelScanningActiveTextAndroidStringAppLabelAwaitConnection = ((modelConnected) ? (activeText.getResources().getString(R.string.app_label_scanning)) : (activeText.getResources().getString(R.string.app_label_await_connection)));
                    // read model.connected ? View.INVISIBLE : View.VISIBLE
                    modelConnectedViewINVISIBLEViewVISIBLE = ((modelConnected) ? (android.view.View.INVISIBLE) : (android.view.View.VISIBLE));
            }
            if ((dirtyFlags & 0x25L) != 0) {

                    if (model != null) {
                        // read model.delinquent
                        modelDelinquent = model.getDelinquent();
                    }


                    // read android.databinding.DynamicUtil.safeUnbox(model.delinquent)
                    androidDatabindingDynamicUtilSafeUnboxModelDelinquent = android.databinding.DynamicUtil.safeUnbox(modelDelinquent);
                if((dirtyFlags & 0x25L) != 0) {
                    if(androidDatabindingDynamicUtilSafeUnboxModelDelinquent) {
                            dirtyFlags |= 0x80L;
                            dirtyFlags |= 0x20000L;
                    }
                    else {
                            dirtyFlags |= 0x40L;
                            dirtyFlags |= 0x10000L;
                    }
                }


                    // read android.databinding.DynamicUtil.safeUnbox(model.delinquent) ? @android:color/holo_red_dark : @android:color/holo_green_dark
                    androidDatabindingDynamicUtilSafeUnboxModelDelinquentSplashButtonAndroidColorHoloRedDarkSplashButtonAndroidColorHoloGreenDark = ((androidDatabindingDynamicUtilSafeUnboxModelDelinquent) ? (getColorFromResource(splashButton, android.R.color.holo_red_dark)) : (getColorFromResource(splashButton, android.R.color.holo_green_dark)));
                    // read android.databinding.DynamicUtil.safeUnbox(model.delinquent) ? View.VISIBLE : View.INVISIBLE
                    androidDatabindingDynamicUtilSafeUnboxModelDelinquentViewVISIBLEViewINVISIBLE = ((androidDatabindingDynamicUtilSafeUnboxModelDelinquent) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.activeText, modelConnectedActiveTextAndroidStringAppLabelScanningActiveTextAndroidStringAppLabelAwaitConnection);
            android.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.imageView2, modelConnectedImageView2AndroidDrawableConnectedImageView2AndroidDrawableConnectivityOff);
            this.mboundView8.setVisibility(modelConnectedViewINVISIBLEViewVISIBLE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.wifiLevel, modelConnectedWifiLevelAndroidStringConnectedWifiLevelAndroidStringDisconnected);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            this.batteryAlert.setVisibility(modelBatteryLevelInt25ViewINVISIBLEViewVISIBLE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.batteryLevel, batteryLevelAndroidStringBatteryLevelFormatModelBatteryLevel);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            this.cameraFab.setOnClickListener(mCallback1);
            this.cameraFab1.setOnClickListener(mCallback3);
            this.verifyFab.setOnClickListener(mCallback2);
            this.verifyFab1.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            this.delinqText.setVisibility(androidDatabindingDynamicUtilSafeUnboxModelDelinquentViewVISIBLEViewINVISIBLE);
            this.infoDel.setVisibility(androidDatabindingDynamicUtilSafeUnboxModelDelinquentViewVISIBLEViewINVISIBLE);
            this.splashLayout.setVisibility(androidDatabindingDynamicUtilSafeUnboxModelDelinquentViewVISIBLEViewINVISIBLE);
            // api target 21
            if(getBuildSdkInt() >= 21) {

                this.splashButton.setBackgroundTintList(android.databinding.adapters.Converters.convertColorToColorStateList(androidDatabindingDynamicUtilSafeUnboxModelDelinquentSplashButtonAndroidColorHoloRedDarkSplashButtonAndroidColorHoloGreenDark));
            }
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // handler
                house_quarantine.liquid_studio.com.android_tracker.main.MainHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onNfcClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // handler
                house_quarantine.liquid_studio.com.android_tracker.main.MainHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCameraClicked();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // handler
                house_quarantine.liquid_studio.com.android_tracker.main.MainHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onNfcClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // handler
                house_quarantine.liquid_studio.com.android_tracker.main.MainHandler handler = mHandler;
                // handler != null
                boolean handlerJavaLangObjectNull = false;



                handlerJavaLangObjectNull = (handler) != (null);
                if (handlerJavaLangObjectNull) {


                    handler.onCameraClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static MainActivityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static MainActivityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<MainActivityBinding>inflate(inflater, house_quarantine.liquid_studio.com.android_tracker.R.layout.main_activity, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static MainActivityBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static MainActivityBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(house_quarantine.liquid_studio.com.android_tracker.R.layout.main_activity, null, false), bindingComponent);
    }
    @NonNull
    public static MainActivityBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static MainActivityBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/main_activity_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new MainActivityBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): handler
        flag 2 (0x3L): model.delinquent
        flag 3 (0x4L): model.connected
        flag 4 (0x5L): model.batteryLevel
        flag 5 (0x6L): null
        flag 6 (0x7L): android.databinding.DynamicUtil.safeUnbox(model.delinquent) ? @android:color/holo_red_dark : @android:color/holo_green_dark
        flag 7 (0x8L): android.databinding.DynamicUtil.safeUnbox(model.delinquent) ? @android:color/holo_red_dark : @android:color/holo_green_dark
        flag 8 (0x9L): model.connected ? @android:string/connected : @android:string/disconnected
        flag 9 (0xaL): model.connected ? @android:string/connected : @android:string/disconnected
        flag 10 (0xbL): model.connected ? @android:drawable/connected : @android:drawable/connectivity_off
        flag 11 (0xcL): model.connected ? @android:drawable/connected : @android:drawable/connectivity_off
        flag 12 (0xdL): model.connected ? @android:string/app_label_scanning : @android:string/app_label_await_connection
        flag 13 (0xeL): model.connected ? @android:string/app_label_scanning : @android:string/app_label_await_connection
        flag 14 (0xfL): model.batteryLevel > 25 ? View.INVISIBLE : View.VISIBLE
        flag 15 (0x10L): model.batteryLevel > 25 ? View.INVISIBLE : View.VISIBLE
        flag 16 (0x11L): android.databinding.DynamicUtil.safeUnbox(model.delinquent) ? View.VISIBLE : View.INVISIBLE
        flag 17 (0x12L): android.databinding.DynamicUtil.safeUnbox(model.delinquent) ? View.VISIBLE : View.INVISIBLE
        flag 18 (0x13L): model.connected ? View.INVISIBLE : View.VISIBLE
        flag 19 (0x14L): model.connected ? View.INVISIBLE : View.VISIBLE
    flag mapping end*/
    //end
}