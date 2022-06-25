package com.example.feature_video_game_info.di

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import com.example.core_common.di.Feature
import com.example.core_network_domain.useCase.game.*
import com.example.feature_video_game_info.screen.VideoGameInfoFragment
import dagger.Component
import kotlin.properties.Delegates

@[Feature Component(dependencies = [GameInfoDeps::class])]
interface GameInfoCompany {

    fun inject(fragment: VideoGameInfoFragment)

    @Component.Builder
    interface Builder{

        fun deps(gameInfoDeps: GameInfoDeps):Builder

        fun build():GameInfoCompany
    }
}

interface GameInfoDeps{
    val getGameInfoUseCase: GetGameInfoUseCase
    val getAchievementsUseCase: GetAchievementsUseCase
    val getScreenshotsUseCase: GetScreenshotsUseCase
    val getDeveloperTeamUseCase:GetDeveloperTeamUseCase
    val getTrailerUseCase: GetTrailerUseCase
}

interface GameInfoDepsProvider{

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps:GameInfoDeps

    companion object : GameInfoDepsProvider by GameInfoDepsStore
}

object GameInfoDepsStore:GameInfoDepsProvider{
    override var deps: GameInfoDeps by Delegates.notNull()
}

internal class GameInfoComponentViewModel:ViewModel(){

    val gameInfoDetailsComponent = DaggerGameInfoCompany.builder()
        .deps(GameInfoDepsProvider.deps)
        .build()

}