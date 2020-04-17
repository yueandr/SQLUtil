package cn.ximoon.sqlutil.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Bean implements Parcelable {

    public String mName;
    public int mAge;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeInt(this.mAge);
    }

    public Bean() {
    }

    protected Bean(Parcel in) {
        this.mName = in.readString();
        this.mAge = in.readInt();
    }

    public static final Creator<Bean> CREATOR = new Creator<Bean>() {
        @Override
        public Bean createFromParcel(Parcel source) {
            return new Bean(source);
        }

        @Override
        public Bean[] newArray(int size) {
            return new Bean[size];
        }
    };
}
