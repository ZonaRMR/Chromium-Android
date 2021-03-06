// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.ui;

import org.chromium.base.annotations.CalledByNative;

/**
 * Simple interface allowing customized response to an overscrolling pull input.
 */
public interface OverscrollRefreshHandler {
    /**
     * Signals the start of an overscrolling pull.
     * @param xDelta The change in horizontal pull distance (positive if pulling down, negative if
     *         up).
     * @param yDelta The change in vertical pull distance.
     * @return Whether the handler will consume the overscroll sequence.
     */
    @CalledByNative
    boolean start(float xDelta, float yDelta);

    /**
     * Signals a pull update.
     * @param xDelta The change in horizontal pull distance (positive if pulling down, negative if
     *         up).
     * @param yDelta The change in vertical pull distance.
     */
    @CalledByNative
    void pull(float xDelta, float yDelta);

    /**
     * Signals the release of the pull.
     * @param allowRefresh Whether the release signal should be allowed to trigger a refresh.
     */
    @CalledByNative
    void release(boolean allowRefresh);

    /**
     * Reset the active pull state.
     */
    @CalledByNative
    void reset();

    /**
     * Toggle whether the effect is active.
     * @param enabled Whether to enable the effect.
     *                If disabled, the effect should deactive itself apropriately.
     */
    void setEnabled(boolean enabled);
}
