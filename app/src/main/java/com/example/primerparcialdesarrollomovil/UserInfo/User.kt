package com.example.primerparcialdesarrollomovil.UserInfo

import android.os.Parcel
import android.os.Parcelable
import androidx.core.view.ContentInfoCompat.Flags

public final data class User (
    val username: String,
    val email: String,
    val name: String,
    val phone: String,
    val age: Int,
): Parcelable{
    constructor(parcel: Parcel): this(
        parcel.readString() ?: "",
        parcel.readString() ?:"",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(name)
        parcel.writeString(phone)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return  0
    }
    companion object CREATOR : Parcelable.Creator<User>{
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }
        override fun newArray(size: Int): Array<User?>{
            return arrayOfNulls(size)
        }
    }
}