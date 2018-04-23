package house_quarantine.liquid_studio.com.android_tracker.databinding;
import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class NfcFragmentBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.nfcimage, 1);
        sViewsWithIds.put(R.id.textView3, 2);
        sViewsWithIds.put(R.id.textView4, 3);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final android.widget.ImageView nfcimage;
    @NonNull
    public final android.widget.TextView textView3;
    @NonNull
    public final android.widget.TextView textView4;
    // variables
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcHandler mHandler;
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcViewModel mModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public NfcFragmentBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nfcimage = (android.widget.ImageView) bindings[1];
        this.textView3 = (android.widget.TextView) bindings[2];
        this.textView4 = (android.widget.TextView) bindings[3];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            setHandler((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcHandler) variable);
        }
        else if (BR.model == variableId) {
            setModel((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcHandler Handler) {
        this.mHandler = Handler;
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcHandler getHandler() {
        return mHandler;
    }
    public void setModel(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcViewModel Model) {
        this.mModel = Model;
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcViewModel getModel() {
        return mModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModel((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModel(house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcViewModel Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static NfcFragmentBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static NfcFragmentBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<NfcFragmentBinding>inflate(inflater, house_quarantine.liquid_studio.com.android_tracker.R.layout.nfc_fragment, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static NfcFragmentBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static NfcFragmentBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(house_quarantine.liquid_studio.com.android_tracker.R.layout.nfc_fragment, null, false), bindingComponent);
    }
    @NonNull
    public static NfcFragmentBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static NfcFragmentBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/nfc_fragment_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new NfcFragmentBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): handler
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}