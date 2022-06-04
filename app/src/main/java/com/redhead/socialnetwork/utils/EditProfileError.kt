package com.redhead.socialnetwork.utils

sealed class EditProfileError : Error() {
    object FieldEmpty : EditProfileError()
}