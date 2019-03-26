package com.nasduck.dialoglib.toast.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.nasduck.dialoglib.base.DuckDialog;
import com.nasduck.dialoglib.base.enums.ToastType;
import com.nasduck.dialoglib.toast.classification.ImageAndTextToast;
import com.nasduck.dialoglib.toast.classification.ImageToast;
import com.nasduck.dialoglib.toast.classification.LoadingToast;
import com.nasduck.dialoglib.toast.classification.TextToast;

public abstract class BaseToastBuilder implements IToastBuilder {

    protected Integer delay;

    protected static ToastHandler mHandler = new ToastHandler();

    public void show(int delay) {
        this.delay = delay;
        show();
    }

    public void show() {
        mHandler.removeMessages(ToastHandler.MSG_SHOW);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(getType().getToastTag());
        switch (getType()) {
            case TEXT_TOAST:
                if (fragment != null) {
                    // Update Toast existing
                    ((TextToast) fragment).updateUI(build());
                } else {
                    // hide other toast
                    hideOtherFragment(getType(), manager);
                    // Show Toast
                    TextToast.create(build()).show(getActivity().getSupportFragmentManager(), getType().getToastTag());
                }
                break;
            case IMAGE_TOAST:
                if (fragment != null) {
                    // Update Toast existing
                    ((ImageToast) fragment).updateUI(build());
                } else {
                    // hide other toast
                    hideOtherFragment(getType(), manager);
                    // Show Toast
                    ImageToast.create(build()).show(getActivity().getSupportFragmentManager(), getType().getToastTag());
                }
                break;
            case TEXT_AND_IMAGE_TOAST:
                if (fragment != null) {
                    // Update Toast existing
                    ((ImageAndTextToast) fragment).updateUI(build());
                } else {
                    // hide other toast
                    hideOtherFragment(getType(), manager);
                    // Show Toast
                    ImageAndTextToast.create(build()).show(getActivity().getSupportFragmentManager(), getType().getToastTag());
                }
                break;
            case LOADING_TOAST:
                if (fragment != null) {
                    // Update Toast existing
                    ((LoadingToast) fragment).updateUI(build());
                } else {
                    // hide other toast
                    hideOtherFragment(getType(), manager);
                    // Show Toast
                    LoadingToast.create(build()).show(getActivity().getSupportFragmentManager(), getType().getToastTag());
                }
                return;
        }
        mHandler.sendEmptyMessageDelayed(ToastHandler.MSG_SHOW, delay);
    }

    @Override
    public void hide() {
        DuckDialog.hide(getActivity(), getType().getToastTag());
    }

    // hide other toast
    private void hideOtherFragment(ToastType type, FragmentManager manager) {
        for (ToastType toastType : ToastType.values()) {
            if (type.getType() != toastType.getType()) {
                if (manager.findFragmentByTag(toastType.getToastTag()) != null) {
                    DuckDialog.hide(getActivity(), toastType.getToastTag());
                }
            }
        }
    }
}
