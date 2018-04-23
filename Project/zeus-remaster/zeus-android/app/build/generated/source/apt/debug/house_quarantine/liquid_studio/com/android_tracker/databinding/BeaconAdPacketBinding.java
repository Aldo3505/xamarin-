package house_quarantine.liquid_studio.com.android_tracker.databinding;
import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BeaconAdPacketBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.lin, 9);
        sViewsWithIds.put(R.id.name_icn, 10);
        sViewsWithIds.put(R.id.range_icon, 11);
    }
    // views
    @NonNull
    public final android.support.v7.widget.CardView cardView;
    @NonNull
    public final android.widget.TextView farName;
    @NonNull
    public final android.widget.LinearLayout lin;
    @NonNull
    public final android.widget.ImageView locationOff;
    @NonNull
    private final android.widget.FrameLayout mboundView1;
    @NonNull
    public final android.widget.TextView name;
    @NonNull
    public final android.widget.RelativeLayout nameIcn;
    @NonNull
    public final android.widget.ProgressBar progressBar2;
    @NonNull
    public final android.widget.RelativeLayout rangeIcon;
    @NonNull
    public final android.widget.TextView textEstimatedRange;
    @NonNull
    public final android.widget.TextView textLastUpdated;
    @NonNull
    public final android.widget.ImageView wearable;
    // variables
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BeaconScanData mModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BeaconAdPacketBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds);
        this.cardView = (android.support.v7.widget.CardView) bindings[0];
        this.cardView.setTag(null);
        this.farName = (android.widget.TextView) bindings[5];
        this.farName.setTag(null);
        this.lin = (android.widget.LinearLayout) bindings[9];
        this.locationOff = (android.widget.ImageView) bindings[3];
        this.locationOff.setTag(null);
        this.mboundView1 = (android.widget.FrameLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.name = (android.widget.TextView) bindings[4];
        this.name.setTag(null);
        this.nameIcn = (android.widget.RelativeLayout) bindings[10];
        this.progressBar2 = (android.widget.ProgressBar) bindings[8];
        this.progressBar2.setTag(null);
        this.rangeIcon = (android.widget.RelativeLayout) bindings[11];
        this.textEstimatedRange = (android.widget.TextView) bindings[7];
        this.textEstimatedRange.setTag(null);
        this.textLastUpdated = (android.widget.TextView) bindings[6];
        this.textLastUpdated.setTag(null);
        this.wearable = (android.widget.ImageView) bindings[2];
        this.wearable.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.model == variableId) {
            setModel((house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BeaconScanData) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BeaconScanData Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BeaconScanData getModel() {
        return mModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        int modelNameLength = 0;
        java.lang.String nameAndroidStringNameFormatModelName = null;
        java.lang.String homeViewModelFormatTimeStampModelTimeStamp = null;
        int modelThreshold = 0;
        android.graphics.drawable.Drawable modelThresholdInt100LocationOffAndroidDrawableProxOffLocationOffAndroidDrawableCustomLocation = null;
        android.graphics.drawable.Drawable modelNameLengthInt6WearableAndroidDrawableWearableIcnWearableAndroidDrawableBeaconIcn = null;
        float modelAccuracy = 0f;
        boolean modelThresholdInt50 = false;
        java.lang.String textEstimatedRangeAndroidStringEstRangeFormatModelAccuracy = null;
        long modelTimeStamp = 0L;
        java.lang.String modelThresholdInt50ModelThresholdInt100FarNameAndroidStringRangeOutFarNameAndroidStringFarFarNameAndroidStringNear = null;
        house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BeaconScanData model = mModel;
        boolean modelNameLengthInt6 = false;
        float modelThresholdInt100Float5fFloat1f = 0f;
        java.lang.String modelAccuracyInt999TextEstimatedRangeAndroidStringNoSignalTextEstimatedRangeAndroidStringEstRangeFormatModelAccuracy = null;
        boolean modelThresholdInt100 = false;
        boolean modelAccuracyInt999 = false;
        java.lang.String modelName = null;
        java.lang.String modelThresholdInt100FarNameAndroidStringRangeOutFarNameAndroidStringFar = null;
        int modelThresholdInt100ViewVISIBLEViewINVISIBLE = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.threshold
                    modelThreshold = model.getThreshold();
                    // read model.accuracy
                    modelAccuracy = model.getAccuracy();
                    // read model.timeStamp
                    modelTimeStamp = model.getTimeStamp();
                    // read model.name
                    modelName = model.getName();
                }


                // read model.threshold > 50
                modelThresholdInt50 = (modelThreshold) > (50);
                // read model.threshold > 100
                modelThresholdInt100 = (modelThreshold) > (100);
                // read model.accuracy > 999
                modelAccuracyInt999 = (modelAccuracy) > (999);
                // read HomeViewModel.formatTimeStamp(model.timeStamp)
                homeViewModelFormatTimeStampModelTimeStamp = house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel.formatTimeStamp(modelTimeStamp);
                // read @android:string/name_format
                nameAndroidStringNameFormatModelName = name.getResources().getString(R.string.name_format, modelName);
            if((dirtyFlags & 0x3L) != 0) {
                if(modelThresholdInt50) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(modelThresholdInt100) {
                        dirtyFlags |= 0x8L;
                        dirtyFlags |= 0x200L;
                        dirtyFlags |= 0x8000L;
                }
                else {
                        dirtyFlags |= 0x4L;
                        dirtyFlags |= 0x100L;
                        dirtyFlags |= 0x4000L;
                }
            }
            if((dirtyFlags & 0x80L) != 0) {
                if(modelThresholdInt100) {
                        dirtyFlags |= 0x2000L;
                }
                else {
                        dirtyFlags |= 0x1000L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(modelAccuracyInt999) {
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x400L;
                }
            }
                if (modelName != null) {
                    // read model.name.length()
                    modelNameLength = modelName.length();
                }


                // read model.threshold > 100 ? @android:drawable/prox_off : @android:drawable/custom_location
                modelThresholdInt100LocationOffAndroidDrawableProxOffLocationOffAndroidDrawableCustomLocation = ((modelThresholdInt100) ? (getDrawableFromResource(locationOff, R.drawable.prox_off)) : (getDrawableFromResource(locationOff, R.drawable.custom_location)));
                // read model.threshold > 100 ? .5f : 1f
                modelThresholdInt100Float5fFloat1f = ((modelThresholdInt100) ? (.5f) : (1f));
                // read model.threshold > 100 ? View.VISIBLE : View.INVISIBLE
                modelThresholdInt100ViewVISIBLEViewINVISIBLE = ((modelThresholdInt100) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
                // read model.name.length() > 6
                modelNameLengthInt6 = (modelNameLength) > (6);
            if((dirtyFlags & 0x3L) != 0) {
                if(modelNameLengthInt6) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read model.name.length() > 6 ? @android:drawable/wearable_icn : @android:drawable/beacon_icn
                modelNameLengthInt6WearableAndroidDrawableWearableIcnWearableAndroidDrawableBeaconIcn = ((modelNameLengthInt6) ? (getDrawableFromResource(wearable, R.drawable.wearable_icn)) : (getDrawableFromResource(wearable, R.drawable.beacon_icn)));
        }
        // batch finished

        if ((dirtyFlags & 0x400L) != 0) {

                // read @android:string/est_range_format
                textEstimatedRangeAndroidStringEstRangeFormatModelAccuracy = textEstimatedRange.getResources().getString(R.string.est_range_format, modelAccuracy);
        }
        if ((dirtyFlags & 0x80L) != 0) {

                // read model.threshold > 100 ? @android:string/rangeOut : @android:string/far
                modelThresholdInt100FarNameAndroidStringRangeOutFarNameAndroidStringFar = ((modelThresholdInt100) ? (farName.getResources().getString(R.string.rangeOut)) : (farName.getResources().getString(R.string.far)));
        }

        if ((dirtyFlags & 0x3L) != 0) {

                // read model.threshold > 50 ? model.threshold > 100 ? @android:string/rangeOut : @android:string/far : @android:string/near
                modelThresholdInt50ModelThresholdInt100FarNameAndroidStringRangeOutFarNameAndroidStringFarFarNameAndroidStringNear = ((modelThresholdInt50) ? (modelThresholdInt100FarNameAndroidStringRangeOutFarNameAndroidStringFar) : (farName.getResources().getString(R.string.near)));
                // read model.accuracy > 999 ? @android:string/no_signal : @android:string/est_range_format
                modelAccuracyInt999TextEstimatedRangeAndroidStringNoSignalTextEstimatedRangeAndroidStringEstRangeFormatModelAccuracy = ((modelAccuracyInt999) ? (textEstimatedRange.getResources().getString(R.string.no_signal)) : (textEstimatedRangeAndroidStringEstRangeFormatModelAccuracy));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.farName, modelThresholdInt50ModelThresholdInt100FarNameAndroidStringRangeOutFarNameAndroidStringFarFarNameAndroidStringNear);
            android.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.locationOff, modelThresholdInt100LocationOffAndroidDrawableProxOffLocationOffAndroidDrawableCustomLocation);
            this.mboundView1.setVisibility(modelThresholdInt100ViewVISIBLEViewINVISIBLE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.name, nameAndroidStringNameFormatModelName);
            this.progressBar2.setProgress(modelThreshold);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textEstimatedRange, modelAccuracyInt999TextEstimatedRangeAndroidStringNoSignalTextEstimatedRangeAndroidStringEstRangeFormatModelAccuracy);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textLastUpdated, homeViewModelFormatTimeStampModelTimeStamp);
            android.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.wearable, modelNameLengthInt6WearableAndroidDrawableWearableIcnWearableAndroidDrawableBeaconIcn);
            // api target 11
            if(getBuildSdkInt() >= 11) {

                this.locationOff.setAlpha(modelThresholdInt100Float5fFloat1f);
            }
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static BeaconAdPacketBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static BeaconAdPacketBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<BeaconAdPacketBinding>inflate(inflater, house_quarantine.liquid_studio.com.android_tracker.R.layout.beacon_ad_packet, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static BeaconAdPacketBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static BeaconAdPacketBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(house_quarantine.liquid_studio.com.android_tracker.R.layout.beacon_ad_packet, null, false), bindingComponent);
    }
    @NonNull
    public static BeaconAdPacketBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static BeaconAdPacketBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/beacon_ad_packet_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new BeaconAdPacketBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
        flag 2 (0x3L): model.threshold > 100 ? @android:drawable/prox_off : @android:drawable/custom_location
        flag 3 (0x4L): model.threshold > 100 ? @android:drawable/prox_off : @android:drawable/custom_location
        flag 4 (0x5L): model.name.length() > 6 ? @android:drawable/wearable_icn : @android:drawable/beacon_icn
        flag 5 (0x6L): model.name.length() > 6 ? @android:drawable/wearable_icn : @android:drawable/beacon_icn
        flag 6 (0x7L): model.threshold > 50 ? model.threshold > 100 ? @android:string/rangeOut : @android:string/far : @android:string/near
        flag 7 (0x8L): model.threshold > 50 ? model.threshold > 100 ? @android:string/rangeOut : @android:string/far : @android:string/near
        flag 8 (0x9L): model.threshold > 100 ? .5f : 1f
        flag 9 (0xaL): model.threshold > 100 ? .5f : 1f
        flag 10 (0xbL): model.accuracy > 999 ? @android:string/no_signal : @android:string/est_range_format
        flag 11 (0xcL): model.accuracy > 999 ? @android:string/no_signal : @android:string/est_range_format
        flag 12 (0xdL): model.threshold > 100 ? @android:string/rangeOut : @android:string/far
        flag 13 (0xeL): model.threshold > 100 ? @android:string/rangeOut : @android:string/far
        flag 14 (0xfL): model.threshold > 100 ? View.VISIBLE : View.INVISIBLE
        flag 15 (0x10L): model.threshold > 100 ? View.VISIBLE : View.INVISIBLE
    flag mapping end*/
    //end
}