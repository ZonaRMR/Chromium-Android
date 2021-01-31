// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.media.router;

/**
 * Interface that groups all the necessary hooks to control media being flung to a Cast device,
 * as part of RemotePlayback.
 * This interface should be the same as media/base/flinging_controller.h.
 */
public interface FlingingController {
    /**
     * Gets the media controller through which we can send commands to the Cast device.
     */
    MediaController getMediaController();

    /**
     * Subscribe or unsubscribe to changes in the MediaStatus.
     */
    void setMediaStatusObserver(MediaStatusObserver observer);
    void clearMediaStatusObserver();

    /**
     * Gets the current media time. Implementers may sacrifice precision in order to avoid a
     * round-trip query to Cast devices (see gms.cast.RemoteMediaPlayer's
     * getApproximateStreamPosition() for example).
     */
    long getApproximateCurrentTime();
}
