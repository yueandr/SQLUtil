package cn.ximoon.sqlutil.bean;

import android.os.Parcel;
import android.os.Parcelable;

import cn.ximoon.sqlutil.logic.model.TestModel;
import cn.ximoon.framework.db.Column;
import cn.ximoon.framework.db.Table;

@Table(name = TestModel.TABLE_NAME)
public class Test implements Parcelable {

	@Column(name = TestModel._ID, primaryKey = true)
	public long _id;
	@Column(name = TestModel.M_NAME)
	public String mName;
	@Column(name = TestModel.M_AGE)
	public int mAge;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(this._id);
		dest.writeString(this.mName);
		dest.writeInt(this.mAge);
	}

	public Test() {
	}

	protected Test(Parcel in) {
		this._id = in.readLong();
		this.mName = in.readString();
		this.mAge = in.readInt();
	}

	public static final Parcelable.Creator<Test> CREATOR = new Parcelable.Creator<Test>() {
		@Override
		public Test createFromParcel(Parcel source) {
			return new Test(source);
		}

		@Override
		public Test[] newArray(int size) {
			return new Test[size];
		}
	};
}
