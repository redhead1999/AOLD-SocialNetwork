package com.redhead.socialnetwork.feature_profile.util

sealed class EditProfileError : Error() {
    object FieldEmpty : EditProfileError()
}