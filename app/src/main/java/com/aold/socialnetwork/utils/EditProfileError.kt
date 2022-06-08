package com.aold.socialnetwork.utils

sealed class EditProfileError : Error() {
    object FieldEmpty : EditProfileError()
}