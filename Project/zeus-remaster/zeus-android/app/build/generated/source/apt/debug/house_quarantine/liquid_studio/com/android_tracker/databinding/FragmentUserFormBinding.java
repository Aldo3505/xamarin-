package house_quarantine.liquid_studio.com.android_tracker.databinding;
import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentUserFormBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.text_register_label, 5);
        sViewsWithIds.put(R.id.text_register_instructions, 6);
        sViewsWithIds.put(R.id.text_layout_full_name, 7);
        sViewsWithIds.put(R.id.text_layout_nric, 8);
        sViewsWithIds.put(R.id.text_layout_address, 9);
        sViewsWithIds.put(R.id.text_layout_contact, 10);
    }
    // views
    @NonNull
    public final android.support.constraint.ConstraintLayout constraintLayout;
    @NonNull
    public final android.support.design.widget.TextInputEditText editTextAddress;
    @NonNull
    public final android.support.design.widget.TextInputEditText editTextContact;
    @NonNull
    public final android.support.design.widget.TextInputEditText editTextFullName;
    @NonNull
    public final android.support.design.widget.TextInputEditText editTextNric;
    @NonNull
    public final android.support.design.widget.TextInputLayout textLayoutAddress;
    @NonNull
    public final android.support.design.widget.TextInputLayout textLayoutContact;
    @NonNull
    public final android.support.design.widget.TextInputLayout textLayoutFullName;
    @NonNull
    public final android.support.design.widget.TextInputLayout textLayoutNric;
    @NonNull
    public final android.widget.TextView textRegisterInstructions;
    @NonNull
    public final android.widget.TextView textRegisterLabel;
    // variables
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormHandler mHandler;
    @Nullable
    private house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel mModel;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener editTextAddressandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.address
            //         is model.setAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editTextAddress);
            // localize variables for thread safety
            // model
            house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel model = mModel;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.address
            java.lang.String modelAddress = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {




                model.setAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener editTextContactandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.phone
            //         is model.setPhone((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editTextContact);
            // localize variables for thread safety
            // model
            house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel model = mModel;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.phone
            java.lang.String modelPhone = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {




                model.setPhone(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener editTextFullNameandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.name
            //         is model.setName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editTextFullName);
            // localize variables for thread safety
            // model
            house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel model = mModel;
            // model.name
            java.lang.String modelName = null;
            // model != null
            boolean modelJavaLangObjectNull = false;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {




                model.setName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener editTextNricandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.nric
            //         is model.setNric((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editTextNric);
            // localize variables for thread safety
            // model
            house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel model = mModel;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.nric
            java.lang.String modelNric = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {




                model.setNric(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentUserFormBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds);
        this.constraintLayout = (android.support.constraint.ConstraintLayout) bindings[0];
        this.constraintLayout.setTag(null);
        this.editTextAddress = (android.support.design.widget.TextInputEditText) bindings[3];
        this.editTextAddress.setTag(null);
        this.editTextContact = (android.support.design.widget.TextInputEditText) bindings[4];
        this.editTextContact.setTag(null);
        this.editTextFullName = (android.support.design.widget.TextInputEditText) bindings[1];
        this.editTextFullName.setTag(null);
        this.editTextNric = (android.support.design.widget.TextInputEditText) bindings[2];
        this.editTextNric.setTag(null);
        this.textLayoutAddress = (android.support.design.widget.TextInputLayout) bindings[9];
        this.textLayoutContact = (android.support.design.widget.TextInputLayout) bindings[10];
        this.textLayoutFullName = (android.support.design.widget.TextInputLayout) bindings[7];
        this.textLayoutNric = (android.support.design.widget.TextInputLayout) bindings[8];
        this.textRegisterInstructions = (android.widget.TextView) bindings[6];
        this.textRegisterLabel = (android.widget.TextView) bindings[5];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
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
            setHandler((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormHandler) variable);
        }
        else if (BR.model == variableId) {
            setModel((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormHandler Handler) {
        this.mHandler = Handler;
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormHandler getHandler() {
        return mHandler;
    }
    public void setModel(@Nullable house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel Model) {
        updateRegistration(0, Model);
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    @Nullable
    public house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel getModel() {
        return mModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModel((house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModel(house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.enabled) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.name) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.nric) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        else if (fieldId == BR.address) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.phone) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
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
        java.lang.String modelPhone = null;
        house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormViewModel model = mModel;
        java.lang.String modelAddress = null;
        java.lang.String modelNric = null;
        boolean modelEnabled = false;
        java.lang.String modelName = null;

        if ((dirtyFlags & 0xfdL) != 0) {


            if ((dirtyFlags & 0xc1L) != 0) {

                    if (model != null) {
                        // read model.phone
                        modelPhone = model.getPhone();
                    }
            }
            if ((dirtyFlags & 0xa1L) != 0) {

                    if (model != null) {
                        // read model.address
                        modelAddress = model.getAddress();
                    }
            }
            if ((dirtyFlags & 0x91L) != 0) {

                    if (model != null) {
                        // read model.nric
                        modelNric = model.getNric();
                    }
            }
            if ((dirtyFlags & 0x85L) != 0) {

                    if (model != null) {
                        // read model.enabled
                        modelEnabled = model.isEnabled();
                    }
            }
            if ((dirtyFlags & 0x89L) != 0) {

                    if (model != null) {
                        // read model.name
                        modelName = model.getName();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x85L) != 0) {
            // api target 1

            this.editTextAddress.setEnabled(modelEnabled);
            this.editTextContact.setEnabled(modelEnabled);
            this.editTextFullName.setEnabled(modelEnabled);
            this.editTextNric.setEnabled(modelEnabled);
        }
        if ((dirtyFlags & 0xa1L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editTextAddress, modelAddress);
        }
        if ((dirtyFlags & 0x80L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextAddress, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextAddressandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextContact, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextContactandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextFullName, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextFullNameandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextNric, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextNricandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xc1L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editTextContact, modelPhone);
        }
        if ((dirtyFlags & 0x89L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editTextFullName, modelName);
        }
        if ((dirtyFlags & 0x91L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editTextNric, modelNric);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentUserFormBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentUserFormBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentUserFormBinding>inflate(inflater, house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_user_form, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentUserFormBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentUserFormBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_user_form, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentUserFormBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentUserFormBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_user_form_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentUserFormBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): handler
        flag 2 (0x3L): model.enabled
        flag 3 (0x4L): model.name
        flag 4 (0x5L): model.nric
        flag 5 (0x6L): model.address
        flag 6 (0x7L): model.phone
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}