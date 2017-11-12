package com.bignerdranch.android.beatbox;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.widget.SeekBar;

import java.text.MessageFormat;

public class PlaybackSpeedViewModel extends BaseObservable {

    private BeatBox mBeatBox;

    public ObservableField<String> mPlaybackSpeedText = new ObservableField<>();
    public ObservableInt mPlaybackSpeedRate = new ObservableInt();

    public PlaybackSpeedViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
        mPlaybackSpeedText.set(MessageFormat.format(mBeatBox.getPlaybackSpeedText(), (int) (mBeatBox.getPlaybackSpeedRate() * 100)));
        mPlaybackSpeedRate.set((int) (mBeatBox.getPlaybackSpeedRate() * 100 - 20));
    }

    public void onSeekBarChange(SeekBar seekBar, int progress, boolean fromUser) {
        mPlaybackSpeedText.set(MessageFormat.format(mBeatBox.getPlaybackSpeedText(), progress + 20));
        mPlaybackSpeedRate.set(progress);
        mBeatBox.setPlaybackSpeedRate((progress + 20.0f) / 100);
    }
}
