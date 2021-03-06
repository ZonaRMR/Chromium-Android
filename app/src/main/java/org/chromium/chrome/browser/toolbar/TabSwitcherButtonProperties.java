// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.toolbar;

import android.content.res.ColorStateList;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

import org.chromium.ui.modelutil.PropertyKey;
import org.chromium.ui.modelutil.PropertyModel.WritableIntPropertyKey;
import org.chromium.ui.modelutil.PropertyModel.WritableObjectPropertyKey;

/**
 * The properties needed to render the tab switcher button.
 */
public interface TabSwitcherButtonProperties {
    /** The current number of tabs. */
    WritableIntPropertyKey NUMBER_OF_TABS = new WritableIntPropertyKey();

    /** The click listener for the tab switcher button. */
    WritableObjectPropertyKey<OnClickListener> ON_CLICK_LISTENER =
            new WritableObjectPropertyKey<>();

    /** The long click listener for the tab switcher button. */
    WritableObjectPropertyKey<OnLongClickListener> ON_LONG_CLICK_LISTENER =
            new WritableObjectPropertyKey<>();

    /** The button tint. */
    WritableObjectPropertyKey<ColorStateList> TINT =
            new WritableObjectPropertyKey<>();

    PropertyKey[] ALL_KEYS =
            new PropertyKey[] {NUMBER_OF_TABS, ON_CLICK_LISTENER, ON_LONG_CLICK_LISTENER, TINT};
}
