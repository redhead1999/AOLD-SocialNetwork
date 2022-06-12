package com.aold.socialnetwork.feature_profile.util

import com.aold.socialnetwork.core.util.Error

sealed class EditProfileError : Error() {
    object FieldEmpty : EditProfileError()
}