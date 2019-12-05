package com.app.shanindu.news.model
import android.os.Parcel
import android.os.Parcelable

data class Newss(
        val id: Int,
        val name: String,
        val email: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
            // A
            parcel.readInt(),
            parcel.readString(),
            parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        // B
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Newss> {
        override fun createFromParcel(parcel: Parcel): Newss {
            return Newss(parcel)
        }

        override fun newArray(size: Int): Array<Newss?> {
            return arrayOfNulls(size)
        }
    }
}