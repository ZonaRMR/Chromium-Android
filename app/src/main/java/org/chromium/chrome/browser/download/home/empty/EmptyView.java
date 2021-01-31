// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.download.home.empty;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.content.res.AppCompatResources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.chromium.chrome.browser.download.home.empty.EmptyProperties.State;
import org.chromium.chrome.browser.widget.LoadingView;
import org.chromium.chrome.download.R;

/** A view that represents the visuals required for the empty state of the download home list. */
class EmptyView {
    private final ViewGroup mView;
    private final TextView mEmptyView;
    private final LoadingView mLoadingView;

    /** Creates a new {@link EmptyView} instance from {@code context}. */
    public EmptyView(Context context) {
        mView = (ViewGroup) LayoutInflater.from(context).inflate(
                R.layout.downloads_empty_view, null);
        mEmptyView = mView.findViewById(R.id.empty);
        mLoadingView = mView.findViewById(R.id.loading);
    }

    /** The Android {@link View} representing the empty view. */
    public View getView() {
        return mView;
    }

    /** Sets the internal UI based on {@code state}. */
    public void setState(@State int state) {
        mEmptyView.setVisibility(state == State.EMPTY ? View.VISIBLE : View.INVISIBLE);

        if (state == State.LOADING) {
            mLoadingView.showLoadingUI();
        } else {
            mLoadingView.hideLoadingUI();
        }
    }

    /** Sets the text resource to use for the empty view. */
    public void setEmptyText(@StringRes int textId) {
        mEmptyView.setText(textId);
    }

    /** Sets the icon resource to use for the empty view. */
    public void setEmptyIcon(@DrawableRes int iconId) {
        mEmptyView.setCompoundDrawablesWithIntrinsicBounds(
                null, AppCompatResources.getDrawable(mView.getContext(), iconId), null, null);
    }
}