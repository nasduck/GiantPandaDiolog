package com.nasduck.dialoglib.config;

import android.os.Parcel;
import android.os.Parcelable;

import com.nasduck.dialoglib.builder.dialog.OneButtonFooterBuilder;
import com.nasduck.dialoglib.builder.dialog.TextBodyBuilder;
import com.nasduck.dialoglib.builder.dialog.TextHeaderBuilder;
import com.nasduck.dialoglib.builder.dialog.ThreeButtonFooterBuilder;
import com.nasduck.dialoglib.builder.dialog.TwoButtonFooterBuilder;
import com.nasduck.dialoglib.enums.GravityWay;
import com.nasduck.dialoglib.interfaces.OnNegativeClickListener;
import com.nasduck.dialoglib.interfaces.OnNormalClickListener;
import com.nasduck.dialoglib.interfaces.OnPositiveClickListener;

public class DialogConfig implements Parcelable {

    private Integer background;
    private Boolean isCancelable;
    private Boolean hasShade;
    // title
    private String titleText;
    private Integer titleTextColor;
    private Integer titleTextSize;

    private GravityWay gravityWay;
    private Integer paddingHorizontal;
    private Integer paddingVertical;

    // content
    private String contentText;
    private Integer contentTextColor;
    private Integer contentTextSize;

    // listener
    private OnNormalClickListener normalClickListener;
    private OnPositiveClickListener positiveClickListener;
    private OnNegativeClickListener negativeClickListener;
    // positive button
    private String positiveButtonText;
    private Integer positiveButtonTextColor;
    private Integer positiveButtonTextSize;
    // negative button
    private String negativeButtonText;
    private Integer negativeButtonTextColor;
    private Integer negativeButtonTextSize;
    // normal button
    private String normalButtonText;
    private Integer normalButtonTextColor;
    private Integer normalButtonTextSize;

    /**********************************************************************************************/

    public DialogConfig(TextHeaderBuilder builder) {
        this.titleText = builder.getTitle();
        this.titleTextSize = builder.getTitleSize();
        this.titleTextColor = builder.getTitleColor();
        this.gravityWay = builder.getGravityWay();
        this.paddingHorizontal = builder.getPaddingHorizontal();
        this.paddingVertical = builder.getPaddingVertical();
    }

    public DialogConfig(TextBodyBuilder builder) {
        this.contentText = builder.getContentText();
        this.contentTextSize = builder.getContentTextSize();
        this.contentTextColor = builder.getContentTextColor();
        this.gravityWay = builder.getGravityWay();
        this.paddingHorizontal = builder.getPaddingHorizontal();
        this.paddingVertical = builder.getPaddingVertical();
    }

    public DialogConfig(OneButtonFooterBuilder builder) {
        this.normalButtonText = builder.getNormalButtonText();
        this.normalButtonTextSize = builder.getNormalButtonTextSize();
        this.normalButtonTextColor = builder.getNormalButtonTextColor();
        this.normalClickListener = builder.getNormalClickListener();
    }

    public DialogConfig(TwoButtonFooterBuilder builder) {
        this.positiveButtonText = builder.getPositiveButtonText();
        this.positiveButtonTextSize = builder.getPositiveButtonTextSize();
        this.positiveButtonTextColor = builder.getPositiveButtonTextColor();
        this.positiveClickListener = builder.getPositiveClickListener();
        this.negativeButtonText = builder.getNegativeButtonText();
        this.negativeButtonTextSize = builder.getNegativeButtonTextSize();
        this.negativeButtonTextColor = builder.getNegativeButtonTextColor();
        this.negativeClickListener = builder.getNegativeClickListener();
    }

    public DialogConfig(ThreeButtonFooterBuilder builder) {
        this.positiveButtonText = builder.getPositiveButtonText();
        this.positiveButtonTextSize = builder.getPositiveButtonTextSize();
        this.positiveButtonTextColor = builder.getPositiveButtonTextColor();
        this.positiveClickListener = builder.getPositiveClickListener();
        this.normalButtonText = builder.getNormalButtonText();
        this.normalButtonTextSize = builder.getNormalButtonTextSize();
        this.normalButtonTextColor = builder.getNormalButtonTextColor();
        this.normalClickListener = builder.getNormalClickListener();
        this.negativeButtonText = builder.getNegativeButtonText();
        this.negativeButtonTextSize = builder.getNegativeButtonTextSize();
        this.negativeButtonTextColor = builder.getNegativeButtonTextColor();
        this.negativeClickListener = builder.getNegativeClickListener();
    }

    /**********************************************************************************************/

    public OnNormalClickListener getNormalClickListener() {
        return normalClickListener;
    }

    public OnPositiveClickListener getPositiveClickListener() {
        return positiveClickListener;
    }

    public OnNegativeClickListener getNegativeClickListener() {
        return negativeClickListener;
    }

    public Integer getBackground() {
        return background;
    }

    public Boolean getCancelable() {
        return isCancelable;
    }

    public Boolean getHasShade() {
        return hasShade;
    }

    public String getTitleText() {
        return titleText;
    }

    public Integer getTitleTextColor() {
        return titleTextColor;
    }

    public Integer getTitleTextSize() {
        return titleTextSize;
    }

    public GravityWay getGravityWay() {
        return gravityWay;
    }

    public Integer getPaddingHorizontal() {
        return paddingHorizontal;
    }

    public Integer getPaddingVertical() {
        return paddingVertical;
    }

    public String getContentText() {
        return contentText;
    }

    public Integer getContentTextColor() {
        return contentTextColor;
    }

    public Integer getContentTextSize() {
        return contentTextSize;
    }

    public String getPositiveButtonText() {
        return positiveButtonText;
    }

    public Integer getPositiveButtonTextColor() {
        return positiveButtonTextColor;
    }

    public Integer getPositiveButtonTextSize() {
        return positiveButtonTextSize;
    }

    public String getNegativeButtonText() {
        return negativeButtonText;
    }

    public Integer getNegativeButtonTextColor() {
        return negativeButtonTextColor;
    }

    public Integer getNegativeButtonTextSize() {
        return negativeButtonTextSize;
    }

    public String getNormalButtonText() {
        return normalButtonText;
    }

    public Integer getNormalButtonTextColor() {
        return normalButtonTextColor;
    }

    public Integer getNormalButtonTextSize() {
        return normalButtonTextSize;
    }

    /**********************************************************************************************/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.background);
        dest.writeValue(this.isCancelable);
        dest.writeValue(this.hasShade);
        dest.writeString(this.titleText);
        dest.writeValue(this.titleTextColor);
        dest.writeValue(this.titleTextSize);
        dest.writeString(this.contentText);
        dest.writeValue(this.contentTextColor);
        dest.writeValue(this.contentTextSize);
        dest.writeString(this.positiveButtonText);
        dest.writeValue(this.positiveButtonTextColor);
        dest.writeValue(this.positiveButtonTextSize);
        dest.writeString(this.negativeButtonText);
        dest.writeValue(this.negativeButtonTextColor);
        dest.writeValue(this.negativeButtonTextSize);
        dest.writeString(this.normalButtonText);
        dest.writeValue(this.normalButtonTextColor);
        dest.writeValue(this.normalButtonTextSize);
    }

    public DialogConfig() {
    }

    protected DialogConfig(Parcel in) {
        this.background = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isCancelable = (Boolean) in.readValue(Integer.class.getClassLoader());
        this.hasShade = (Boolean) in.readValue(Integer.class.getClassLoader());
        this.titleText = in.readString();
        this.titleTextColor = (Integer) in.readValue(Integer.class.getClassLoader());
        this.titleTextSize = (Integer) in.readValue(Integer.class.getClassLoader());
        this.contentText = in.readString();
        this.contentTextColor = (Integer) in.readValue(Integer.class.getClassLoader());
        this.contentTextSize = (Integer) in.readValue(Integer.class.getClassLoader());
        this.positiveButtonText = in.readString();
        this.positiveButtonTextColor = (Integer) in.readValue(Integer.class.getClassLoader());
        this.positiveButtonTextSize = (Integer) in.readValue(Integer.class.getClassLoader());
        this.negativeButtonText = in.readString();
        this.negativeButtonTextColor = (Integer) in.readValue(Integer.class.getClassLoader());
        this.negativeButtonTextSize = (Integer) in.readValue(Integer.class.getClassLoader());
        this.normalButtonText = in.readString();
        this.normalButtonTextColor = (Integer) in.readValue(Integer.class.getClassLoader());
        this.normalButtonTextSize = (Integer) in.readValue(Integer.class.getClassLoader());

    }

    public static final Creator<DialogConfig> CREATOR = new Creator<DialogConfig>() {
        @Override
        public DialogConfig createFromParcel(Parcel source) {
            return new DialogConfig(source);
        }

        @Override
        public DialogConfig[] newArray(int size) {
            return new DialogConfig[size];
        }
    };
}
