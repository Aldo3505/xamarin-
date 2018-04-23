package house_quarantine.liquid_studio.com.android_tracker.databinding;
import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentQrBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.text_register_beacon, 3);
        sViewsWithIds.put(R.id.text_register_instructions, 4);
        sViewsWithIds.put(R.id.camera_preview, 5);
    }
    // views
    @NonNull
    public final house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.CameraPreview cameraPreview;
    @NonNull
    public final android.support.constraint.ConstraintLayout constraintLayout;
    @NonNull
    public final android.support.design.widget.FloatingActionButton fab2;
    @NonNull
    public final android.widget.TextView textRegisterBeacon;
    @NonNull
    public final android.widget.TextView textRegisterInstructions;
    @NonNull
    public final android.widget.ProgressBar uploadProgress;
    // variables
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRHandler mHandler;
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRViewModel mModel;
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentQrBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.cameraPreview = (house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.CameraPreview) bindings[5];
        this.constraintLayout = (android.support.constraint.ConstraintLayout) bindings[0];
        this.constraintLayout.setTag(null);
        this.fab2 = (android.support.design.widget.FloatingActionButton) bindings[2];
        this.fab2.setTag(null);
        this.textRegisterBeacon = (android.widget.TextView) bindings[3];
        this.textRegisterInstructions = (android.widget.TextView) bindings[4];
        this.uploadProgress = (android.widget.ProgressBar) bindings[1];
        this.uploadProgress.setTag(null);
        setRootTag(root);
        // listeners
        mCallback6 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setHandler((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRHandler) variable);
        }
        else if (BR.model == variableId) {
            setModel((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRHandler Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRHandler getHandler() {
        return mHandler;
    }
    public void setModel(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRViewModel Model) {
        updateRegistration(0, Model);
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRViewModel getModel() {
        return mModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModel((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModel(house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRViewModel Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.scanning) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        boolean modelScanning = false;
        house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRHandler handler = mHandler;
        house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRViewModel model = mModel;
        int modelScanningViewVISIBLEViewINVISIBLE = 0;
        int modelScanningFab2AndroidColorDarkBlueFab2AndroidColorHoloRedDark = 0;

        if ((dirtyFlags & 0xdL) != 0) {



                if (model != null) {
                    // read model.scanning
                    modelScanning = model.isScanning();
                }
            if((dirtyFlags & 0xdL) != 0) {
                if(modelScanning) {
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x40L;
                }
            }


                // read model.scanning ? View.VISIBLE : View.INVISIBLE
                modelScanningViewVISIBLEViewINVISIBLE = ((modelScanning) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
                // read model.scanning ? @android:color/darkBlue : @android:color/holo_red_dark
                modelScanningFab2AndroidColorDarkBlueFab2AndroidColorHoloRedDark = ((modelScanning) ? (getColorFromResource(fab2, R.color.darkBlue)) : (getColorFromResource(fab2, android.R.color.holo_red_dark)));
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 21
            if(getBuildSdkInt() >= 21) {

                this.fab2.setBackgroundTintList(android.databinding.adapters.Converters.convertColorToColorStateList(modelScanningFab2AndroidColorDarkBlueFab2AndroidColorHoloRedDark));
            }
            // api target 1

            this.uploadProgress.setVisibility(modelScanningViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.fab2.setOnClickListener(mCallback6);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // handler
        house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRHandler handler = mHandler;
        // handler != null
        boolean handlerJavaLangObjectNull = false;



        handlerJavaLangObjectNull = (handler) != (null);
        if (handlerJavaLangObjectNull) {


            handler.toggleScan();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentQrBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentQrBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentQrBinding>inflate(inflater, house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_qr, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentQrBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentQrBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_qr, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentQrBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentQrBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_qr_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentQrBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): handler
        flag 2 (0x3L): model.scanning
        flag 3 (0x4L): null
        flag 4 (0x5L): model.scanning ? View.VISIBLE : View.INVISIBLE
        flag 5 (0x6L): model.scanning ? View.VISIBLE : View.INVISIBLE
        flag 6 (0x7L): model.scanning ? @android:color/darkBlue : @android:color/holo_red_dark
        flag 7 (0x8L): model.scanning ? @android:color/darkBlue : @android:color/holo_red_dark
    flag mapping end*/
    //end
}