package house_quarantine.liquid_studio.com.android_tracker.databinding;
import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FacialRegistrationBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView2, 1);
        sViewsWithIds.put(R.id.textView, 2);
        sViewsWithIds.put(R.id.profile_image, 3);
        sViewsWithIds.put(R.id.guideline7, 4);
        sViewsWithIds.put(R.id.guideline, 5);
        sViewsWithIds.put(R.id.fab, 6);
        sViewsWithIds.put(R.id.temp_image, 7);
    }
    // views
    @NonNull
    public final android.support.design.widget.FloatingActionButton fab;
    @NonNull
    public final android.support.constraint.Guideline guideline;
    @NonNull
    public final android.support.constraint.Guideline guideline7;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView profileImage;
    @NonNull
    public final android.widget.ImageView tempImage;
    @NonNull
    public final android.widget.TextView textView;
    @NonNull
    public final android.widget.TextView textView2;
    // variables
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceHandler mHandler;
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceViewModel mModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FacialRegistrationBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.fab = (android.support.design.widget.FloatingActionButton) bindings[6];
        this.guideline = (android.support.constraint.Guideline) bindings[5];
        this.guideline7 = (android.support.constraint.Guideline) bindings[4];
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.profileImage = (de.hdodenhof.circleimageview.CircleImageView) bindings[3];
        this.tempImage = (android.widget.ImageView) bindings[7];
        this.textView = (android.widget.TextView) bindings[2];
        this.textView2 = (android.widget.TextView) bindings[1];
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
            setHandler((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceHandler) variable);
        }
        else if (BR.model == variableId) {
            setModel((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceHandler Handler) {
        this.mHandler = Handler;
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceHandler getHandler() {
        return mHandler;
    }
    public void setModel(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceViewModel Model) {
        this.mModel = Model;
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceViewModel getModel() {
        return mModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModel((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModel(house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceViewModel Model, int fieldId) {
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
    public static FacialRegistrationBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FacialRegistrationBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FacialRegistrationBinding>inflate(inflater, house_quarantine.liquid_studio.com.android_tracker.R.layout.facial_registration, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FacialRegistrationBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FacialRegistrationBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(house_quarantine.liquid_studio.com.android_tracker.R.layout.facial_registration, null, false), bindingComponent);
    }
    @NonNull
    public static FacialRegistrationBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FacialRegistrationBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/facial_registration_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FacialRegistrationBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): handler
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}