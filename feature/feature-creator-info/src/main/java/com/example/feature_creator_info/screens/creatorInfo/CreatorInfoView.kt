package com.example.feature_creator_info.screens.creatorInfo

import com.example.feature_creator_info.screens.creatorInfo.state.CreatorInfoState

interface CreatorInfoView {
    fun renderState(state:CreatorInfoState)
}