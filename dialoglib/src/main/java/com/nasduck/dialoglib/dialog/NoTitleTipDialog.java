package com.nasduck.dialoglib.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nasduck.dialoglib.Base.ConfigName;
import com.nasduck.dialoglib.R;
import com.nasduck.dialoglib.config.DialogTipNoTitleConfigBean;
import com.nasduck.dialoglib.interfaces.BaseDialogFragment;

public class NoTitleTipDialog extends BaseDialogFragment {

    private LinearLayout mLayoutBackground;
    private TextView mTvContent;
    private Button mBtnSure;

    private String mContentText;
    private int mContentTextColor;
    private int mContentTextSize;
    private String mButtonText;
    private int mButtonTextColor;
    private int mButtonTextSize;

    private onSureClickListener listener;

    public interface onSureClickListener{
        void onSureClick();
    }

    public NoTitleTipDialog() {

    }

    public static NoTitleTipDialog newTextToast(DialogTipNoTitleConfigBean configBean){
        NoTitleTipDialog fragment = new NoTitleTipDialog();
        Bundle args = new Bundle();
        args.putInt(ConfigName.BACKGROUND, configBean.getBackground());
        args.putBoolean(ConfigName.IS_CANCELABLE, configBean.isCancelable());
        args.putBoolean(ConfigName.HAS_SHADE, configBean.isHasShade());
        args.putString(ConfigName.CONTENT_TEXT, configBean.getContentText());
        args.putInt(ConfigName.CONTENT_TEXT_COLOR, configBean.getContentTextColor());
        args.putInt(ConfigName.CONTENT_TEXT_SIZE, configBean.getContentTextSize());
        args.putString(ConfigName.TIP_BUTTON_TEXT, configBean.getButtonText());
        args.putInt(ConfigName.TIP_BUTTON_TEXT_COLOR, configBean.getButtonTextColor());
        args.putInt(ConfigName.TIP_BUTTON_TEXT_SIZE, configBean.getButtonTextSize());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBackground = getArguments().getInt(ConfigName.BACKGROUND);
            isCancelable = getArguments().getBoolean(ConfigName.IS_CANCELABLE);
            hasShade = getArguments().getBoolean(ConfigName.HAS_SHADE);
            mContentText = getArguments().getString(ConfigName.CONTENT_TEXT);
            mContentTextColor = getArguments().getInt(ConfigName.CONTENT_TEXT_COLOR);
            mContentTextSize = getArguments().getInt(ConfigName.CONTENT_TEXT_SIZE);
            mButtonText = getArguments().getString(ConfigName.TIP_BUTTON_TEXT);
            mButtonTextSize = getArguments().getInt(ConfigName.TIP_BUTTON_TEXT_SIZE);
            mButtonTextColor = getArguments().getInt(ConfigName.TIP_BUTTON_TEXT_COLOR);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_tip_no_title;
    }

    @Override
    protected void initEventAndData() {
        mLayoutBackground = view.findViewById(R.id.background);
        mTvContent = view.findViewById(R.id.tv_content);
        mBtnSure = view.findViewById(R.id.btn_sure);

        mLayoutBackground.setBackgroundResource(mBackground);
        setCancelable(isCancelable);
        setShade(hasShade);
        mTvContent.setText(mContentText);
        mTvContent.setTextColor(getResources().getColor(mContentTextColor));
        mTvContent.setTextSize(mContentTextSize);
        mBtnSure.setText(mButtonText);
        mBtnSure.setTextColor(getResources().getColor(mButtonTextColor));
        mBtnSure.setTextSize(mButtonTextSize);
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onSureClick();
                    hide();
                }
            }
        });
    }

    @Override
    protected void hide() {
        this.dismiss();
    }

    public NoTitleTipDialog setOnSureClickListener(onSureClickListener listener) {
        this.listener = listener;
        return this;
    }
}